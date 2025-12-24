package com.pangci.starter.mq.rabbit.config;

import com.pangci.starter.mq.rabbit.core.enums.ExchangeEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * RabbitMQ 配置类
 */
@ConfigurationProperties("rabbit.config")
@Validated
@Data
public class RabbitProperties {
    /**
     * 是否开启配置化交换机队列绑定,默认为开启
     */
    public boolean enabled=true;

    /**
     * 交换机配置
     */
    public ExchangeProperties[] exchanges;

    /**
     * 交换机配置类
     */
    @Data
    @Valid
    public static class ExchangeProperties{
        /**
         * 交换机名称
         */
        @NotEmpty(message = "交换机名称不能为空")
        private String name;
        /**
         * 交换机类型
         */
        private ExchangeEnum type;
        /**
         * 队列配置
         */
        private QueueProperties[] queues;
        /**
         * 队列配置类
         */
        @Data
        @Valid
        public static class QueueProperties{
            /**
             * 队列名称
             */
            @NotEmpty(message = "队列名称不能为空")
            private String name;
            /**
             * 队列绑定的交换机使用的RoutingKey
             */
            private String RoutingKey;
            /**
             * 队列最大长度
             */
            private long maxLength;
            /**
             * 队列TTL
             */
            private int ttl;
            /**
             * 死信交换机名称
             */
            private String deadLetterExchange;
            /**
             * 死信路由键
             */
            private String deadLetterRoutingKey;
        }
    }
}
