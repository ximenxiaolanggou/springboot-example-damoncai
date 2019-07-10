package com.ximen.rabbitmq.queues;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="itcast")
public class Consumer {
    @RabbitHandler
    public void getQueuesMessage(String message){
        System.out.println("接收到的消息是：" + message);
    }
}
