package com.ximen.rabbitmq.direct;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author zhishun.cai
 * @date 2020/5/24 8:44
 * @note
 */
@Component
public class EmailReceiver {

    @RabbitListener( queues = "EmailQueue")
    public void receiver(String msg){
        System.out.println("Msg is : " + msg);
    }
}
