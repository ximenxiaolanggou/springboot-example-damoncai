package com.ximen.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="itheima")
public class ConsumerTopicTwo {
    @RabbitHandler
    public void getQueuesMessage(String message){
        System.out.println("topic2：" + message);
    }
}
