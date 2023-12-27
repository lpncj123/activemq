package cn.lp.mynettyTask.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.mynettyTask.client
 * @Author: lp
 * @CreateTime: 2023-12-25  17:15
 * @Description: TODO
 * @Version: 1.0
 */
public class TaskClient {
    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            //创建客户端启动对象
            //注意客户端使用的不是 ServerBootstrap 而是 Bootstrap
            Bootstrap bootstrap = new Bootstrap();

            //设置相关参数
            bootstrap.group(group) //设置线程组
                .channel(NioSocketChannel.class) // 设置客户端通道的实现类(反射)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast("decoder", new StringDecoder());
                        pipeline.addLast("encoder", new StringEncoder());
                        pipeline.addLast(new SimpleClientHandler()); //加入自己的处理器
                    }
                });

            System.out.println("客户端 ok..");

            //启动客户端去连接服务器端
            //关于 ChannelFuture 要分析，涉及到netty的异步模型
//            ChannelFuture channelFuture = bootstrap.connect("localhost", 7000).sync();
//            channelFuture.channel().closeFuture().sync();
            Channel channel = bootstrap.connect("localhost", 7000).sync().channel();

//             从控制台读取输入并发送到服务器
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String message = reader.readLine();
                if (message != null && !message.isEmpty()) {
                    channel.writeAndFlush(message + "\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            group.shutdownGracefully();

        }
    }
}
