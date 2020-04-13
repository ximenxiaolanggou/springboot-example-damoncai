package com.ximen.io.rpc.server;

/**
 * @author zhishun.cai
 * @date 2020/4/3 9:01
 * @note
 */
public class HelloServiceImpl implements HelloService {
    public String hello(String name) {
        return "你好," + name;
    }
}
