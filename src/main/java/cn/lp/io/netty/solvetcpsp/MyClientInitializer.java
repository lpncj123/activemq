package cn.lp.io.netty.solvetcpsp;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.io.netty.tcpstickypacket
 * @Author: lp
 * @CreateTime: 2023-03-01  17:57
 * @Description: TODO
 * @Version: 1.0
 */
public class MyClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast(new MyMessageEncoder()); //加入编码器
        pipeline.addLast(new MyMessageDecoder()); //加入解码器
        pipeline.addLast(new MyClientHandler());
    }
}
