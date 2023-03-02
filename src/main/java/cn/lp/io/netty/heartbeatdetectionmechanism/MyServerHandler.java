package cn.lp.io.netty.heartbeatdetectionmechanism;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.io.netty.heartbeatdetectionmechanism
 * @Author: lp
 * @CreateTime: 2023-03-01  11:38
 * @Description: TODO
 * @Version: 1.0
 */
public class MyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     *
     * @param ctx 上下文
     * @param evt 事件
     * @throws Exception
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {

        if(evt instanceof IdleStateEvent) {

            //将  evt 向下转型 IdleStateEvent
            IdleStateEvent event = (IdleStateEvent) evt;
            String eventType = null;
            /**
             * @description: 读空闲（READER_IDLE）：表示客户端在指定的时间内没有向服务器发送任何数据，即服务器在等待客户端发送数据时，客户端没有发送任何数据。
             *
             * 写空闲（WRITER_IDLE）：表示客户端在指定的时间内没有从服务器读取任何数据，即客户端在等待服务器发送数据时，服务器没有发送任何数据。
             *
             * 读写空闲（ALL_IDLE）：表示客户端在指定的时间内既没有向服务器发送数据，也没有从服务器读取任何数据，即客户端在一段时间内没有任何的操作。
             **/
            switch (event.state()) {
                case READER_IDLE:
                    eventType = "读空闲";
                    break;
                case WRITER_IDLE:
                    eventType = "写空闲";
                    break;
                case ALL_IDLE:
                    eventType = "读写空闲";
                    break;
            }
            System.out.println(ctx.channel().remoteAddress() + "--超时时间--" + eventType);
            System.out.println("服务器做相应处理..");

            //如果发生空闲，我们关闭通道
            // ctx.channel().close();
        }
    }
}
