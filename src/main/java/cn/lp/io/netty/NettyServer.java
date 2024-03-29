package cn.lp.io.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.io.netty
 * @Author: lp
 * @CreateTime: 2023-02-28  13:50
 * @Description: TODO
 * @Version: 1.0
 */
public class NettyServer {
    public static void main(String[] args) throws Exception {


        //创建BossGroup 和 WorkerGroup
        //说明
        //1. 创建两个线程组 bossGroup 和 workerGroup
        //2. bossGroup 只是处理连接请求 , 真正的和客户端业务处理，会交给 workerGroup完成
        //3. 两个都是无限循环
        //4. bossGroup 和 workerGroup 含有的子线程(NioEventLoop)的个数
        //   默认实际 cpu核数 * 2
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup(); //8


        try {
            //创建服务器端的启动对象，配置参数
            ServerBootstrap bootstrap = new ServerBootstrap();

            //使用链式编程来进行设置
            /**
             *bootstrap.group(bossGroup, workerGroup)：设置两个线程组，一个是用于接收客户端连接的 boss 线程组，另一个是用于处理客户端连接请求的 worker 线程组。
             * channel(NioServerSocketChannel.class)：设置服务端使用的通道实现为 NioServerSocketChannel，这是 Netty 封装的基于 Java NIO 的 SocketChannel。
             * option(ChannelOption.SO_BACKLOG, 128)：设置服务端监听的端口可以接受的客户端连接数，即等待连接的队列长度。
             * childOption(ChannelOption.SO_KEEPALIVE, true)：设置客户端连接的 TCP 会话保持活跃状态。
             * childHandler(new ChannelInitializer<SocketChannel>() { ... }：用于初始化客户端连接的 ChannelPipeline，当一个新的客户端连接建立时，Netty 会创建一个新的 NioSocketChannel 对象，然后调用该 ChannelInitializer 的 initChannel() 方法初始化新创建的 Channel 的 ChannelPipeline。其中，SocketChannel 表示客户端连接的通道实现。
             * ch.pipeline().addLast(new NettyServerHandler())：向客户端连接的 ChannelPipeline 中添加自定义的业务处理器，即 NettyServerHandler。
             **/
            bootstrap.group(bossGroup, workerGroup) //设置两个线程组
                .channel(NioServerSocketChannel.class) //使用NioSocketChannel 作为服务器的通道实现
                .option(ChannelOption.SO_BACKLOG, 128) // 设置线程队列等待连接个数
                .childOption(ChannelOption.SO_KEEPALIVE, true) //设置保持活动连接状态
//                    .handler(new LoggingHandler(LogLevel.INFO)) // 该 handler对应 bossGroup , childHandler 对应 workerGroup
                .childHandler(new ChannelInitializer<SocketChannel>() {//创建一个通道初始化对象(匿名对象)
                    //给pipeline 设置处理器
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        System.out.println("客户socketchannel hashcode=" + ch.hashCode()); //可以使用一个集合管理 SocketChannel， 再推送消息时，可以将业务加入到各个channel 对应的 NIOEventLoop 的 taskQueue 或者 scheduleTaskQueue
                        ch.pipeline().addLast(new NettyServerHandler());
                    }
                }); // 给我们的workerGroup 的 EventLoop 对应的管道设置处理器

            System.out.println(".....服务器 is ready...");

            //绑定一个端口并且同步生成了一个 ChannelFuture 对象（也就是立马返回这样一个对象）
            //启动服务器(并绑定端口)
            ChannelFuture cf = bootstrap.bind(6668).sync();

            //给cf 注册监听器，监控我们关心的事件

            cf.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if (cf.isSuccess()) {
                        System.out.println("监听端口 6668 成功");
                    } else {
                        System.out.println("监听端口 6668 失败");
                    }
                }
            });


            //对关闭通道事件  进行监听
            cf.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }

}
