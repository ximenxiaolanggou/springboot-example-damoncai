package com.ximen.io.rpc.server;

import com.ximen.io.netty.chart.ChatServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolver;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author zhishun.cai
 * @date 2020/4/3 22:41
 * @note
 */
public class RPCServer {

    public static void main(String[] args) {

        //1.创建线程组：接收客户端连接
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //2.创建线程组：处理网络操作
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try{
            //3.创建服务器端启动助手来配置参数
            ServerBootstrap sb = new ServerBootstrap();
            sb.group(bossGroup,workerGroup) //4.设置两个线程组
                    .channel(NioServerSocketChannel.class) //5.使用NioServerSocketChannel作为服务器端通道的实现
                    .option(ChannelOption.SO_BACKLOG,128) // 6.设置线程队列中等待连接的个数
                    .childOption(ChannelOption.SO_KEEPALIVE,true)// 7.保持活动连接状态
                    .childHandler(new ChannelInitializer<SocketChannel>() { //8. 创建一个通道初始化对象
                        @Override
                        public void initChannel(SocketChannel sc) throws Exception {
                            ChannelPipeline pipeline = sc.pipeline();
                            //往pipeline链中添加一个解码器
                            pipeline.addLast("decoder",new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));
                            //往pipeline链中添加一个编码器
                            pipeline.addLast("encoder",new ObjectEncoder());
                            pipeline.addLast(new InvokeHandler()); //9. 往Pipeline链中添加自定义的handler类
                        }
                    });
            System.out.println("............Netty Chat Server启动............");
            ChannelFuture cf = sb.bind(9995).sync(); //10. 端口绑定 非阻塞
            //11.关闭通道,关闭线程
            cf.channel().closeFuture().sync(); // 异步
        }catch (Exception e){

        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
