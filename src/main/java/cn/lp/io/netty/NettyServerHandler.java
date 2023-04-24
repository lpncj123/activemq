package cn.lp.io.netty;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.util.concurrent.TimeUnit;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.io.netty
 * @Author: lp
 * @CreateTime: 2023-02-28  14:32
 * @Description: TODO
 * @Version: 1.0
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    //读取数据事件(这里我们可以读取客户端发送的消息)
    /*
    1. ChannelHandlerContext ctx:上下文对象, 含有 管道pipeline , 通道channel, 地址
    2. Object msg: 就是客户端发送的数据 默认Object
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 比如这里我们有一个非常耗时长的业务-> 异步执行 -> 提交该channel 对应的
        // NIOEventLoop 的 taskQueue中,

        // 解决方案1 用户程序自定义的普通任务

        ctx.channel().eventLoop().execute(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(5 * 1000);
                    ctx.writeAndFlush(Unpooled.copiedBuffer("hello, 客户端~(>^ω^<)喵2", CharsetUtil.UTF_8));
                    System.out.println("channel code=" + ctx.channel().hashCode());
                } catch (Exception ex) {
                    System.out.println("发生异常" + ex.getMessage());
                }
            }
        });

        ctx.channel().eventLoop().execute(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(5 * 1000);
                    ctx.writeAndFlush(Unpooled.copiedBuffer("hello, 客户端~(>^ω^<)喵3", CharsetUtil.UTF_8));
                    System.out.println("channel code=" + ctx.channel().hashCode());
                } catch (Exception ex) {
                    System.out.println("发生异常" + ex.getMessage());
                }
            }
        });

        //解决方案2 : 用户自定义定时任务 -》 该任务是提交到 scheduleTaskQueue中

        ctx.channel().eventLoop().schedule(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5 * 1000);
                    ctx.writeAndFlush(Unpooled.copiedBuffer("hello, 客户端~(>^ω^<)喵4", CharsetUtil.UTF_8));
                    System.out.println("channel code=" + ctx.channel().hashCode());
                } catch (Exception ex) {
                    System.out.println("发生异常" + ex.getMessage());
                }
            }
        }, 5, TimeUnit.SECONDS);

        System.out.println("go on ...");

//        System.out.println("服务器读取线程 " + Thread.currentThread().getName() + " channle =" + ctx.channel());
//        System.out.println("server ctx =" + ctx);
//        System.out.println("看看channel 和 pipeline的关系");
//        Channel channel = ctx.channel();
//        ChannelPipeline pipeline = ctx.pipeline(); //本质是一个双向链接, 出站入站
//
//        //将 msg 转成一个 ByteBuf
//        //ByteBuf 是 Netty 提供的，不是 NIO 的 ByteBuffer.
//        ByteBuf buf = (ByteBuf) msg;
//        System.out.println("客户端发送消息是:" + buf.toString(CharsetUtil.UTF_8));
//        System.out.println("客户端地址:" + channel.remoteAddress());
    }

    //数据读取完毕
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

        //writeAndFlush 是 write + flush
        //将数据写入到缓存，并刷新
        //一般讲，我们对这个发送的数据进行编码
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello, 客户端~(>^ω^<)喵1", CharsetUtil.UTF_8));
    }

    //发生异常后, 一般是需要关闭通道

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("Exception occurred, close the channel and release resources.");
        ctx.close();
    }
    /**
     * @description: 当一个 Channel 的连接被关闭或者断开时，它的状态会从 ACTIVE 变为 INACTIVE，此时 channelInactive() 方法就会被调用。在这个方法中，可以进行一些资源释放、清理等操作。
     * @author: lp
     * @date: 2023/3/28 16:07
     * @param: [ctx]
     * @return: void
     **/
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Channel is inactive, close the channel and release resources.");
        ctx.close(); // 关闭通道
        // 释放资源，清理缓存等操作
    }
}
