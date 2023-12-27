package cn.lp.mynettyTask.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.mynettyTask.server
 * @Author: lp
 * @CreateTime: 2023-12-27  16:28
 * @Description: TODO
 * @Version: 1.0
 */
public class SimpleServerHandler extends SimpleChannelInboundHandler<String> {

    // 存储在线的客户端通道
    private static final Map<String, Channel> channels = new ConcurrentHashMap<>();

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
        System.out.println("username："+incoming.id().asShortText()+"加入了");
        // 在客户端连接时，将通道加入在线客户端列表
        channels.put(incoming.id().asShortText(), incoming);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel incoming = ctx.channel();

        // 解析私聊消息格式为 "@username:message"
        if (msg.startsWith("@")) {
            String[] parts = msg.split(":", 2);
            if (parts.length == 2) {
                String targetUser = parts[0].substring(1);
                String message = parts[1].trim();

                // 获取目标用户的通道
                Channel targetChannel = channels.get(targetUser);

                if (targetChannel != null) {
                    // 发送私聊消息给目标用户
                    targetChannel.writeAndFlush("[Private Message] " + incoming.remoteAddress() + ": " + message + "\n");
                    incoming.writeAndFlush("[Private Message] Sent to " + targetUser + ": " + message + "\n");
                } else {
                    incoming.writeAndFlush("[System Message] User " + targetUser + " is not online\n");
                }
            }
        } else {
            incoming.writeAndFlush("[System Message] Invalid message format. Use @username:message to send private messages.\n");
        }
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
        // 在客户端断开连接时，从在线客户端列表中移除通道
        channels.remove(incoming.id().asShortText());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        cause.printStackTrace();
        ctx.close();
    }

//    @Override
//    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
//        Channel channel = ctx.channel();
//        channel.writeAndFlush( channel.remoteAddress() + "你好，感谢你发送了消息" + msg + "\n");
//
//    }
}
