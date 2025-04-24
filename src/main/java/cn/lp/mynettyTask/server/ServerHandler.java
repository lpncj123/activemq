package cn.lp.mynettyTask.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.mynettyTask.server
 * @Author: lp
 * @CreateTime: 2023-12-25  16:55
 * @Description: TODO
 * @Version: 1.0
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {
//public class ServerHandler extends SimpleChannelInboundHandler<String> {
//    public static Map<String, Channel> channels = new HashMap<String,Channel>();
//    //表示channel 处于活动状态, 提示 xx上线
//    @Override
//    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
//        Channel incoming = ctx.channel();
//        System.out.println("加入用户id:"+incoming.id().asShortText());
//        // 在客户端连接时，将通道加入在线客户端列表
//        channels.put(incoming.id().asShortText(), incoming);
//    }
//
//    @Override
//    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
//        Channel incoming = ctx.channel();
//        System.out.println("读到client的消息"+ msg);
//        // 解析私聊消息格式为 "@username:message"
//        if (msg.startsWith("@")) {
//            String[] parts = msg.split(":", 2);
//            if (parts.length == 2) {
//                String targetUser = parts[0].substring(1);
//                String message = parts[1].trim();
//
//                // 获取目标用户的通道
//                Channel targetChannel = channels.get(targetUser);
//
//                if (targetChannel != null) {
//                    // 发送私聊消息给目标用户
//                    targetChannel.writeAndFlush(Unpooled.copiedBuffer("[Private Message] " + incoming.remoteAddress() + ": " + message + "\n", CharsetUtil.UTF_8));
//                    incoming.writeAndFlush(Unpooled.copiedBuffer("[Private Message] Sent to " + targetUser + ": " + message + "\n",CharsetUtil.UTF_8));
//                } else {
//                    incoming.writeAndFlush(Unpooled.copiedBuffer("[System Message] User " + targetUser + " is not online\n",CharsetUtil.UTF_8));
//                }
//            }
//        } else {
//            incoming.writeAndFlush(Unpooled.copiedBuffer("[System Message] Invalid message format. Use @username:message to send private messages.\n",CharsetUtil.UTF_8));
//        }
//    }
//
//    @Override
//    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
//        Channel incoming = ctx.channel();
//        // 在客户端断开连接时，从在线客户端列表中移除通道
//        channels.remove(incoming.id().asShortText());
//    }
//
//    @Override
//    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        ctx.close();
//    }
















    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //这个是给服务端看的，客户端上面已经提示xxx加入群聊了
        System.out.println(ctx.channel().remoteAddress() + " 上线了~");
    }

    //表示channel 处于不活动状态, 提示 xx离线了
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

        System.out.println(ctx.channel().remoteAddress() + " 离线了~");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("读到client的消息"+ buf.toString(CharsetUtil.UTF_8));
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello, 客户端", CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}