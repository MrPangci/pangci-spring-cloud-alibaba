package com.pangci.starter.mq.rabbit.config;

import cn.hutool.core.util.StrUtil;
import com.pangci.starter.mq.rabbit.core.enums.ExchangeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@AutoConfiguration
@EnableConfigurationProperties({RabbitProperties.class})
@ConditionalOnProperty(prefix = "rabbit.config", name = "enabled", havingValue = "true", matchIfMissing = true)
@Slf4j
public class RabbitAutoConfiguration {

    /**
     * 动态创建交换机、队列，以及绑定关系
     * @param rabbitProperties
     * @return
     */
    @Bean
    public Declarables dynamicDeclarables(RabbitProperties rabbitProperties) {
        List<Declarable> declarableList = new ArrayList<>();
        for(RabbitProperties.ExchangeProperties exchangeProperties:rabbitProperties.getExchanges()){
            Exchange exchange = getExchange(exchangeProperties.getType(),exchangeProperties.getName());
            declarableList.add(exchange);//添加交换机
            for(RabbitProperties.ExchangeProperties.QueueProperties queueProperties:exchangeProperties.getQueues()){
                QueueBuilder queueBuilder = QueueBuilder.durable(queueProperties.getName());
                long maxLength = queueProperties.getMaxLength();
                int ttl = queueProperties.getTtl();
                String deadLetterExchange = queueProperties.getDeadLetterExchange();
                String deadLetterRoutingKey = queueProperties.getDeadLetterRoutingKey();
                if(maxLength>0L){//设置队列最大长度
                    queueBuilder.maxLength(maxLength);
                }
                if(ttl>0){//设置队列TTL
                    queueBuilder.ttl(ttl);
                }
                if(!StrUtil.hasBlank(deadLetterExchange)){//设置死信交换机
                    queueBuilder.deadLetterExchange(deadLetterExchange);
                }
                if(!StrUtil.hasBlank(deadLetterRoutingKey)){//设置死信路由键
                    queueBuilder.deadLetterRoutingKey(deadLetterRoutingKey);
                }
                Queue queue = queueBuilder.build();
                declarableList.add(queue);//添加队列
                String RoutingKey = queueProperties.getRoutingKey();
                declarableList.add(getBinding(queue,exchange,RoutingKey,exchangeProperties.getType()));//添加绑定关系
            }
        }
        return new Declarables(declarableList);
    }

    /**
     * 获取绑定关系
     * @param queue 队列
     * @param exchange 交换机
     * @param RoutingKey 路由键
     * @param exchangeEnum 交换机枚举类型
     * @return
     */
    private Binding getBinding(Queue queue,Exchange exchange,String RoutingKey,ExchangeEnum exchangeEnum){
        BindingBuilder.DestinationConfigurer destinationConfigurer=BindingBuilder.bind(queue);
        Binding binding =null;
        switch (exchangeEnum){
            case DIRECT:
                binding=destinationConfigurer.to((DirectExchange) exchange).with(RoutingKey);
                break;
            case FANOUT:
                binding=destinationConfigurer.to((FanoutExchange) exchange);
                break;
            case TOPICS:
                binding=destinationConfigurer.to((TopicExchange) exchange).with(RoutingKey);
                break;
            default:
                break;
        }
        return binding;
    }

    /**
     * 获取交换机
     * @param exchangeEnum 交换机枚举类型
     * @param exchangeName 交换机名称
     * @return
     */
    private Exchange getExchange(ExchangeEnum exchangeEnum,String exchangeName){
        Exchange exchange=null;
        switch (exchangeEnum){
            case DIRECT:
                exchange=ExchangeBuilder.directExchange(exchangeName).durable(true).build();
                break;
            case FANOUT:
                exchange=ExchangeBuilder.fanoutExchange(exchangeName).durable(true).build();
                break;
            case TOPICS:
                exchange=ExchangeBuilder.topicExchange(exchangeName).durable(true).build();
                break;
            default:
                break;
        }
        return exchange;
    }
}
