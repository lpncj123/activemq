package cn.lp.io.netty.solvetcpsp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.io.netty.solvetcpsp
 * @Author: lp
 * @CreateTime: 2023-03-01  18:09
 * @Description: TODO
 * @Version: 1.0
 */
public class MyMessageDecoder extends ReplayingDecoder<Void> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println();
        System.out.println();
        System.out.println("MyMessageDecoder decode 被调用");
        //需要将得到二进制字节码-> MessageProtocol 数据包(对象)
//        这里的关键是 ReplayingDecoder 会在读取字节时自动进行判断，如果字节不足，它会等待更多的字节到来，直到足够的字节被读取。
        int length = in.readInt();

        byte[] content = new byte[length];
        in.readBytes(content);

        //封装成 MessageProtocol 对象，放入 out， 传递下一个handler业务处理
        MessageProtocol messageProtocol = new MessageProtocol();
        messageProtocol.setLen(length);
        messageProtocol.setContent(content);

        //放入out传给下一个hanlder进行处理
        out.add(messageProtocol);

    }
}
