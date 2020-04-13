package com.ximen.io.rpc.client;

import com.ximen.io.rpc.clientStub.NettyPRCProxy;

/**
 * @author zhishun.cai
 * @date 2020/4/3 22:53
 * @note
 */
public class Remote {
    public static void main(String[] args) {
        HelloService helloService = (HelloService)NettyPRCProxy.getInstance(HelloService.class);
        System.out.println( helloService.hello("damon"));
    }
}
