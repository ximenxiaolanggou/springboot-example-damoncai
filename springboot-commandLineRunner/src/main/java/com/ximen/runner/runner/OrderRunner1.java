package com.ximen.runner.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author ZhiShun.Cai
 * @Date 2019/10/3 9:31
 */
@Component
@Order(1) //重小到大执行顺序
public class OrderRunner1 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println(args + ": OrderRunner1");
    }
}
