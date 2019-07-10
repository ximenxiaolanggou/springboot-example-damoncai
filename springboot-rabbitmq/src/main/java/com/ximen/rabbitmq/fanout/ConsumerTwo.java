package com.ximen.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="itheima")
public class ConsumerTwo {
    @RabbitHandler
    public void getQueuesMessage(String message){
        System.out.println("itheima：" + message);
    }
}
