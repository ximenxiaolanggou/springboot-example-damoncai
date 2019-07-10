package com.ximen.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="kudingyu")
public class ConsumerThree {
    @RabbitHandler
    public void getQueuesMessage(String message){
        System.out.println("kudingyu：" + message);
    }
}
