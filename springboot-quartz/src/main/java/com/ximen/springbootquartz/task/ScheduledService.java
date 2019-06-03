package com.ximen.springbootquartz.task;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
//@EnableScheduling
public class ScheduledService {
    @Scheduled(cron = "0/2 * * * * *")
    public void scheduled(){
        System.out.println(Thread.currentThread().getName()+"---123");
    }

    @Scheduled(cron = "0/2 * * * * *")
    public void scheduled2(){
        System.out.println(Thread.currentThread().getName()+"---123456");
    }
}
