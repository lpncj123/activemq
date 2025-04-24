package cn.lp.mynettyTask.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.mynettyTask.server
 * @Author: lp
 * @CreateTime: 2023-12-25  16:44
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskServer {
    private int port;
    public void run() throws InterruptedException {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup,workerGroup)
            .channel(NioServerSocketChannel.class)
            .option(ChannelOption.SO_BACKLOG,128)
            .childOption(ChannelOption.SO_KEEPALIVE,true)
            .childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();
                    pipeline.addLast("decoder", new StringDecoder());
                    pipeline.addLast("encoder", new StringEncoder());
                    pipeline.addLast(new SimpleServerHandler());
                }
            });
        System.out.println(".....服务器 is ready...");
        ChannelFuture cf = serverBootstrap.bind(port).sync();
        cf.addListener((ChannelFutureListener) future -> {
            if (cf.isSuccess()) {
                System.out.println("监听端口 7000 成功");
            } else {
                System.out.println("监听端口 7000 失败");
            }
        });


        //对关闭通道事件  进行监听
        cf.channel().closeFuture().sync();
    }

    public static void main(String[] args) throws InterruptedException {
        new TaskServer(7000).run();
    }
}
