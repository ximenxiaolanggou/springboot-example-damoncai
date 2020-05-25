package com.ximen.provider.direct;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhishun.cai
 * @date 2020/5/24 8:30
 * @note
 */
@RestController
@RequestMapping("mail")
public class EmailController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping
    public Object send(String msg){
        rabbitTemplate.convertAndSend("EmailExchange","EmailRoutingKey",msg);
        return "ok";
    }
}
