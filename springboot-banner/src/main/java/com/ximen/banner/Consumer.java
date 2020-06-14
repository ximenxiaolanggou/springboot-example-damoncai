package com.ximen.banner;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author zhishun.cai
 * @date 2020/6/2 8:58
 * @note
 */
@Component
public class Consumer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(name="cloud-futaba-queue"), //不设置name则创建临时队列
                    exchange = @Exchange(type = "topic",name="dataInfoTopic"),
                    key={"dataInfo"}
            )
    })
    public void receive1(String message){
        System.out.println("message1 = " + message);
    }
}
