package com.ximen.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author simba@onlying.cn
 * @date 2020/3/8 13:15
 * @note
 */
@Component
public class ConsumerListener {

    @KafkaListener(topics = "testTopic",groupId = "ximen")
    public void onMessage(String message) {
        //insertIntoDb(buffer);//这里为插入数据库代码
        System.out.println("ximen：" + message);
    }

    @KafkaListener(topics = "testTopic",groupId = "damon")
    public void onMessage2(String message) {
        //insertIntoDb(buffer);//这里为插入数据库代码
        System.out.println("damon：" + message);
    }
}