package cn.lp.io.netty.groupchatsystem;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.io.netty.groupchatsystem
 * @Author: lp
 * @CreateTime: 2023-03-01  11:14
 * @Description: TODO
 * @Version: 1.0
 */
public class GroupChatClientHandler extends SimpleChannelInboundHandler<String> {

    //从服务器拿到的数据
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg.trim());
    }
}