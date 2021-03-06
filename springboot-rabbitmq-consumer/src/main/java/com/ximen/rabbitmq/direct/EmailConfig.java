package com.ximen.rabbitmq.direct;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhishun.cai
 * @date 2020/5/24 8:28
 * @note
 */
@Configuration
public class EmailConfig {

    @Bean
    DirectExchange emailExchange(){
        return new DirectExchange("EmailExchange");
    }

    @Bean
    Queue EmailQueue(){
        return new Queue("EmailQueue");
    }

    @Bean
    Binding EmailBind(){
        return BindingBuilder.bind(EmailQueue()).to(emailExchange()).with("EmailRoutingKey");
    }
}
