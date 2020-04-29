package com.ximen.client.netty;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.EventLoop;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author zhishun.cai
 * @date 2020/4/14 16:01
 * @note
 */
@Component
public class ConnectionListener implements ChannelFutureListener {
    @Override
    public void operationComplete(ChannelFuture channelFuture) throws Exception {
        if (!channelFuture.isSuccess()) {
            final EventLoop loop = channelFuture.channel().eventLoop();
            loop.schedule(new Runnable() {
                @Override
                public void run() {
                    System.err.println("服务端链接不上，开始重连操作...");
                    try {
                        Client.run();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 3, TimeUnit.SECONDS);
        } else {
            Client.channel = channelFuture.channel();
            System.err.println("服务端链接成功...");
        }
    }
}
