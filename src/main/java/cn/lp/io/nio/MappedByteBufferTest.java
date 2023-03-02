package cn.lp.io.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.io.nio
 * @Author: lp
 * @CreateTime: 2023-02-24  17:11
 * @Description: NIO 还提供了 MappedByteBuffer，可以让文件直接在内存（堆外的内存）中进行修改，而如何同步到文件由 NIO 来完成。
 * @Version: 1.0
 */
public class MappedByteBufferTest {
    public static void main(String[] args) throws Exception {
        /**
         * RandomAccessFile 是 Java 提供的一种文件读写类，它可以在文件中随意移动指针并进行读写操作。与其他流不同的是，RandomAccessFile 既可以读取数据也可以写入数据，而且可以任意跳转文件指针。它支持读写随机访问文件，即可以从文件的任意位置开始读写数据，而不必按顺序从头到尾读写。
         * 可以通过 RandomAccessFile 构造函数中的 mode 参数来指定读写模式，常见的模式有 "r"（只读模式）、"rw"（读写模式）等。
         **/
        RandomAccessFile randomAccessFile = new RandomAccessFile("test.txt", "rw");
        //获取对应的通道
        FileChannel channel = randomAccessFile.getChannel();

        /**
         * 参数 1:FileChannel.MapMode.READ_WRITE 使用的读写模式
         * 参数 2：0：可以直接修改的起始位置
         * 参数 3:5: 是映射到内存的大小（不是索引位置），即将 1.txt 的多少个字节映射到内存
         * 可以直接修改的范围就是 0-5
         * 实际类型 DirectByteBuffer
         */
        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 4);

        mappedByteBuffer.put(1, (byte) 'H');
        mappedByteBuffer.put(2, (byte) '9');
        mappedByteBuffer.put(3, (byte) 'Y');//IndexOutOfBoundsException
        mappedByteBuffer.force();
        randomAccessFile.close();
        channel.close();
        System.out.println("修改成功~~");
    }
}
