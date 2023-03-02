package cn.lp.io.netty.tcpstickypacket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.io.netty.tcpstickypacket
 * @Author: lp
 * @CreateTime: 2023-03-01  17:55
 * @Description: TODO
 * @Version: 1.0
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast(new MyServerHandler());
    }
}