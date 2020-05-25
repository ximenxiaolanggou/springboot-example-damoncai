package com.ximen.rabbitmq.topic;

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

    @Bean
    Queue BlogJavaQueue(){
        return new Queue("BlogJavaQueue",true);
    }

    @Bean
    Queue BlogCQueue(){
        return new Queue("BlogCQueue",true);
    }

    @Bean
    Queue BlogAllQueue(){
        return new Queue("BlogAllQueue",true);
    }


    @Bean
    Binding JavaBind(){
        return BindingBuilder.bind(BlogJavaQueue()).to(BlogExchange()).with("blog.java");
    }

    @Bean
    Binding CBind(){
        return BindingBuilder.bind(BlogCQueue()).to(BlogExchange()).with("blog.c");
    }

    @Bean
    Binding AllBind(){
        return BindingBuilder.bind(BlogAllQueue()).to(BlogExchange()).with("blog.#");
    }
}
