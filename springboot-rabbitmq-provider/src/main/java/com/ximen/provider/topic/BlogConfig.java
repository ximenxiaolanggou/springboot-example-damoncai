package com.ximen.provider.topic;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhishun.cai
 * @date 2020/5/24 8:28
 * @note
 */
@Configuration
public class BlogConfig {

    @Bean
    TopicExchange BlogExchange(){
        return new TopicExchange("BlogExchange");
    }
}
