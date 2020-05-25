package com.ximen.provider.topic;

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
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping
    public Object send1(String msg){
        rabbitTemplate.convertAndSend("BlogExchange","blog.java",msg);
        return "ok";
    }
}
