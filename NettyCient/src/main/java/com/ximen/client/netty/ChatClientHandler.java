package com.ximen.client.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author: 西门小狼狗
 * @Date: 2019/5/23 9:58
 */
public class ChatClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {
        System.out.println( s.trim() + "\n");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("11"+ cause);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Client.run();
    }
}
