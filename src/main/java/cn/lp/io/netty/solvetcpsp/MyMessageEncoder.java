package cn.lp.io.netty.solvetcpsp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.io.netty.solvetcpsp
 * @Author: lp
 * @CreateTime: 2023-03-01  18:09
 * @Description: TODO
 * @Version: 1.0
 */
public class MyMessageEncoder extends MessageToByteEncoder<MessageProtocol> {
    @Override
    protected void encode(ChannelHandlerContext ctx, MessageProtocol msg, ByteBuf out) throws Exception {
        System.out.println("MyMessageEncoder encode 方法被调用");
        out.writeInt(msg.getLen());
        out.writeBytes(msg.getContent());
    }
}
