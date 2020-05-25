package com.ximen.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author zhishun.cai
 * @date 2020/5/24 8:44
 * @note
 */
@Component
public class FanoutReceiver {

    @RabbitListener( queues = "FanoutQueue")
    public void receiver1(String msg){
        System.out.println(" 1 Msg is : " + msg);
    }

    @RabbitListener( queues = "FanoutQueue")
    public void receiver2(String msg){
        System.out.println(" 2 Msg is : " + msg);
    }
}
