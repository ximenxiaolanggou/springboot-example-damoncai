package com.ximen.provider.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
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
}
