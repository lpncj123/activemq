package cn.lp.io.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.io.nio
 * @Author: lp
 * @CreateTime: 2023-02-24  15:26
 * @Description: TODO
 * @Version: 1.0
 */
public class FileChannelWriteExample {
    public static void main(String[] args) throws Exception {
        String str = "你好，哈哈哈\n的萨克达侃大山";
        //创建一个输出流 -> channel
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\file01.txt");

        //通过 fileOutputStream 获取对应的 FileChannel
        //这个 fileChannel 真实类型是 FileChannelImpl
        FileChannel fileChannel = fileOutputStream.getChannel();

        //创建一个缓冲区 ByteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //将 str 放入 byteBuffer
        byteBuffer.put(str.getBytes());

        //对 byteBuffer 进行 flip
        /**
         * intBuffer.flip() 是 java.nio.IntBuffer 类的方法之一，用于准备读取缓冲区的数据。
         * 具体来说，它会将 IntBuffer 对象的 limit 属性设置为当前的 position，然后将 position 重置为 0。这
         * 样一来，之前在 IntBuffer 中写入的数据就可以被读取了。
         **/
        byteBuffer.flip();

        //将 byteBuffer 数据写入到 fileChannel
        fileChannel.write(byteBuffer);
        fileOutputStream.close();
    }
}
