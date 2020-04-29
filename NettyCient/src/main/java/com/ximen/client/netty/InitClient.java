package com.ximen.client.netty;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author zhishun.cai
 * @date 2020/4/14 16:12
 * @note
 */
@Component
public class InitClient implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Client.run();
    }
}
