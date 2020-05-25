package com.ximen.provider.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhishun.cai
 * @date 2020/5/24 8:44
 * @note
 */
@RestController
@RequestMapping("fanout")
public class FanoutController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping
    public Object send(String msg){
        rabbitTemplate.convertAndSend("FanoutExchange",null,msg);
        return "ok";
    }
}
