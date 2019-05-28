package com.ximen.springbootquartz.autostart;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * 在项目启动的时候立刻执行某些方法
 * 我们可以通过实现ApplicationRunner和CommandLineRunner来实现
 */
@Component
public class MyApplicationRunner implements ApplicationRunner{

    @Override
    public void run(ApplicationArguments var1) throws Exception{
        System.out.println("MyApplicationRunner1!");
    }

}