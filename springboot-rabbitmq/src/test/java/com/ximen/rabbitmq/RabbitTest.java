package com.ximen.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitMqApplication.class)
public class RabbitTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 直连
     */
    @Test
    public void testQueues(){
        rabbitTemplate.convertAndSend("itcast","我要红包");
    }

    /**
     * 分裂
     */
    @Test
    public void testFanout(){
        rabbitTemplate.convertAndSend("heima", "", "biubiubiu");
    }

    /**
     * 主题
     */
    @Test
    public void testTopic(){
        rabbitTemplate.convertAndSend("ximen", "good.qwe", "biubiubiu");
    }
}
