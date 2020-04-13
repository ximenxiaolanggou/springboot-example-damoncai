package com.ximen.io.rpc.server;

import com.ximen.io.rpc.info.ClassInfo;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.lang.reflect.Method;

/**
 * @author zhishun.cai
 * @date 2020/4/3 22:40
 * @note
 */
public class InvokeHandler extends ChannelInboundHandlerAdapter {
    //读取事件
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ClassInfo classInfo = (ClassInfo) msg;
        String classPath = "com.ximen.io.rpc.server." + classInfo.getClassName();
        System.out.println(classPath);
        //TODO获取接口实现类
        String localPath = "com.ximen.io.rpc.server.HelloServiceImpl";
        Class<?> aClass = Class.forName(localPath);
        Object o = aClass.newInstance();
        Method method = aClass.getMethod(classInfo.getMethodName(), classInfo.getArgTypes());
        Object res = method.invoke(o, classInfo.getArgs());
        ctx.channel().writeAndFlush(res);
        System.out.println(classInfo);
    }

}
