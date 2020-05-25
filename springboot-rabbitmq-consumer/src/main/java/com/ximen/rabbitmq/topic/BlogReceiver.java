package com.ximen.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author zhishun.cai
 * @date 2020/5/24 8:44
 * @note
 */
@Component
public class BlogReceiver {

    @RabbitListener( queues = "BlogJavaQueue")
    public void javaReceiver(String msg){
        System.out.println("JAVA BLOG 01 Msg is : " + msg);
    }

    @RabbitListener( queues = "BlogJavaQueue")
    public void javaReceiver2(String msg){
        System.out.println("JAVA BLOG 02 Msg is : " + msg);
    }

    @RabbitListener( queues = "BlogCQueue")
    public void cReceiver(String msg){
        System.out.println("C BLOG Msg is : " + msg);
    }

    @RabbitListener( queues = "BlogAllQueue")
    public void receiver(String msg){
        System.out.println("ALL BLOG Msg is : " + msg);
    }
}
