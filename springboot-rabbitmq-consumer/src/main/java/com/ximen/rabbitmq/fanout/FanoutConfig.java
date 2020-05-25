package com.ximen.rabbitmq.fanout;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhishun.cai
 * @date 2020/5/24 8:28
 * @note
 */
@Configuration
public class FanoutConfig {

    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("FanoutExchange");
    }

    @Bean
    Queue FanoutQueue(){
        return new Queue("FanoutQueue");
    }

    @Bean
    Binding FanoutBind(){
        return BindingBuilder.bind(FanoutQueue()).to(fanoutExchange());
    }
}
