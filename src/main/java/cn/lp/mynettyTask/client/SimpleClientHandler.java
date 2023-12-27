package cn.lp.mynettyTask.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.mynettyTask.client
 * @Author: lp
 * @CreateTime: 2023-12-27  16:27
 * @Description: TODO
 * @Version: 1.0
 */
public class SimpleClientHandler extends SimpleChannelInboundHandler<String> {
    //从服务器拿到的数据
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg.trim());
    }
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client " + ctx);
        ctx.writeAndFlush("hello, server: (>^ω^<)喵");
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("Exception occurred, close the channel and release resources.");
        ctx.close(); // 关闭通道
    }
}
