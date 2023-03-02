package cn.lp.io.nio;

import java.io.File;
import java.io.FileInputStream;
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
public class FileChannelReadExample {
    public static void main(String[] args) throws Exception {
        //创建文件的输入流
        File file = new File("d:\\file01.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        //通过 fileInputStream 获取对应的 FileChannel -> 实际类型 FileChannelImpl
        FileChannel fileChannel = fileInputStream.getChannel();
        //创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)file.length());
        //将通道的数据读入到 Buffer
        fileChannel.read(byteBuffer);

        //将 byteBuffer 的字节数据转成 String
        System.out.println(new String(byteBuffer.array()));
        fileInputStream.close();
    }
}
