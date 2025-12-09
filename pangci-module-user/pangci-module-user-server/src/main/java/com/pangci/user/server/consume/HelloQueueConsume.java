package com.pangci.user.server.consume;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HelloQueueConsume {
    @RabbitListener(queues = "helloQueue")
    public void receiveNotification(String message) {
        System.out.println("消费内容: " + message);
    }
}
