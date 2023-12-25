package cn.lp.mynettyTask.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.mynettyTask.client
 * @Author: lp
 * @CreateTime: 2023-12-25  17:17
 * @Description: TODO
 * @Version: 1.0
 */
public class ClientHandler extends SimpleChannelInboundHandler<String> {

    //从服务器拿到的数据
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg.trim());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush("你好，客户端");
    }
}
