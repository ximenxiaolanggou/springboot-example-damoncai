package com.ximen.io.netty.codec;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Author: 西门小狼狗
 * @Date: 2019/5/22 19:28
 */

/**
 * 服务器端的业务处理类
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    //读取事件
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        BookMessage.Book book =  (BookMessage.Book)msg;
        System.out.println("客户端传过来的书名是：" + book.getName());
    }

}
