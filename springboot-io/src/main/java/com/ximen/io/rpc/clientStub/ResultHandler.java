package com.ximen.io.rpc.clientStub;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @author zhishun.cai
 * @date 2020/4/3 9:11
 * @note
 */
public class ResultHandler extends ChannelInboundHandlerAdapter {

    private Object object;

    public Object getObject(){
        return object;
    }

    //读取事件
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        this.object = msg;
        ctx.close();
    }
}
