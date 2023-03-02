package cn.lp.io.netty.groupchatsystem;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.io.netty.groupchatsystem
 * @Author: lp
 * @CreateTime: 2023-03-01  11:13
 * @Description: TODO
 * @Version: 1.0
 */
public class GroupChatClient {
    //属性
    private final String host;
    private final int port;

    public GroupChatClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void run() throws Exception{
        EventLoopGroup group = new NioEventLoopGroup();

        try {


            Bootstrap bootstrap = new Bootstrap()
                .group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
/**
 * @description:这段代码是 Netty 框架中创建一个 ChannelPipeline 对象，并向其中添加两个 Handler 的过程。
 *
 * 具体作用如下：
 * StringDecoder 是一个解码器，用于将接收到的字节数据转换成字符串对象。因为网络通信时传输的数据都是二进制数据，而应用程序需要处理的却是字符串或其他类型的数据，所以需要一个解码器将二进制数据解码为应用程序可处理的数据类型。
 * StringEncoder 是一个编码器，用于将应用程序处理完后的字符串数据转换成字节数据。同样地，网络通信时需要将数据转换成二进制数据进行传输，所以需要一个编码器将数据编码为二进制数据。
 * 将这两个 Handler 添加到 ChannelPipeline 中，表示当数据通过网络传输到服务器或客户端时，Netty 将使用这两个 Handler 对数据进行解码和编码，使得应用程序可以方便地处理字符串类型的数据，而无需考虑网络传输中的数据格式问题。
 **/
                        //得到pipeline
                        ChannelPipeline pipeline = ch.pipeline();
                        //加入相关handler
                        pipeline.addLast("decoder", new StringDecoder());
                        pipeline.addLast("encoder", new StringEncoder());
                        //加入自定义的handler
                        pipeline.addLast(new GroupChatClientHandler());
                    }
                });

            ChannelFuture channelFuture = bootstrap.connect(host, port).sync();
            //得到channel
            Channel channel = channelFuture.channel();
            System.out.println("-------" + channel.localAddress()+ "--------");
            //客户端需要输入信息，创建一个扫描器
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String msg = scanner.nextLine();
                //通过channel 发送到服务器端
                channel.writeAndFlush(msg + "\r\n");
            }
        }finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        new GroupChatClient("127.0.0.1", 7000).run();
    }
}
