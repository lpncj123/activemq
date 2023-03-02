package cn.lp.io.nio;

import java.nio.ByteBuffer;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.io.nio
 * @Author: lp
 * @CreateTime: 2023-02-24  17:10
 * @Description: 可以将一个普通 Buffer 转成只读 Buffer
 * @Version: 1.0
 */
public class ReadOnlyBuffer {
    public static void main(String[] args) {

        //创建一个 buffer
        ByteBuffer buffer = ByteBuffer.allocate(64);

        for (int i = 0; i < 64; i++) {
            buffer.put((byte) i);
        }

        //读取
        buffer.flip();

        //得到一个只读的 Buffer
        ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();
        System.out.println(readOnlyBuffer.getClass());

        //读取
        while (readOnlyBuffer.hasRemaining()) {
            System.out.println(readOnlyBuffer.get());
        }

        readOnlyBuffer.put((byte) 100); //ReadOnlyBufferException
    }
}
