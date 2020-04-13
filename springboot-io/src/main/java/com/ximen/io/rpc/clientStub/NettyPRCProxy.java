package com.ximen.io.rpc.clientStub;

import com.ximen.io.netty.basic.NettyClientHandler;
import com.ximen.io.rpc.info.ClassInfo;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhishun.cai
 * @date 2020/4/3 9:11
 * @note
 */
public class NettyPRCProxy {

    private Class<?> aClass;

    public NettyPRCProxy(Class<?> aClass){
        this.aClass = aClass;
    }

    public static Object getInstance(final Class<?> aClass){

        Object o = Proxy.newProxyInstance(aClass.getClassLoader(), new Class[]{aClass}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                final ResultHandler handler = new ResultHandler();
                //1.收集ClassInfo
                ClassInfo classInfo = new ClassInfo();
                classInfo.setArgs(args);
                classInfo.setArgTypes(method.getParameterTypes());
                classInfo.setClassName(aClass.getName());
                classInfo.setMethodName(method.getName());
                //2.发送数据

                //1.创建线程组
                EventLoopGroup group = new NioEventLoopGroup();
                //2.创建客户端的启动助手，完成相关配置
                Bootstrap b = new Bootstrap();
                b.group(group) // 3. 设置线程组
                        .channel(NioSocketChannel.class) // 4.设置客户端通道的实现类
                        .handler(new ChannelInitializer<SocketChannel>() { // 5. 创建通道初始化对象
                            @Override
                            protected void initChannel(SocketChannel sc) throws Exception {
                                ChannelPipeline pipeline = sc.pipeline();
                                //往pipeline链中添加一个解码器
                                pipeline.addLast("decoder",new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));
                                //往pipeline链中添加一个编码器
                                pipeline.addLast("encoder",new ObjectEncoder());
                                pipeline.addLast(handler); // 6.往pipeline链中添加自定义handler
                            }
                        });
                System.out.println("..........CLient is ready..........");
                //7.启动客户端去连接服务器端(异步非阻塞)
                ChannelFuture cf = b.connect("127.0.0.1", 9995).sync();
                Channel channel = cf.channel();
                channel.writeAndFlush(classInfo).sync();
                //8.关闭连接(异步非阻塞)
                cf.channel().closeFuture().sync();
                return handler.getObject();
            }
        });
        return o;
    }
}
