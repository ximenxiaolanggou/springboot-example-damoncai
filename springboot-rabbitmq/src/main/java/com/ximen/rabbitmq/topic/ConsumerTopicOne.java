package com.ximen.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="itcast")
public class ConsumerTopicOne {
    @RabbitHandler
    public void getQueuesMessage(String message){
        System.out.println("topic1：" + message);
    }
}
