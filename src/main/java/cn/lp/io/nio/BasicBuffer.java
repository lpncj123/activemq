package cn.lp.io.nio;

import java.nio.IntBuffer;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.io.nio
 * @Author: lp
 * @CreateTime: 2023-02-24  15:10
 * @Description: TODO
 * @Version: 1.0
 */
public class BasicBuffer {
    public static void main(String[] args) {

        //举例说明 Buffer 的使用(简单说明)
        //创建一个 Buffer，大小为 5，即可以存放 5 个 int
        IntBuffer intBuffer = IntBuffer.allocate(5);
        //向buffer存放数据
        //intBuffer.put(10);
        //intBuffer.put(11);
        //intBuffer.put(12);
        //intBuffer.put(13);
        //intBuffer.put(14);
        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i * 2);
        }
        //如何从 buffer 读取数据
        //将 buffer 转换，读写切换(!!!)
        /**
         * intBuffer.flip() 是 java.nio.IntBuffer 类的方法之一，用于准备读取缓冲区的数据。具体来说，
         * 它会将 IntBuffer 对象的 limit 属性设置为当前的 position，然后将 position 重置为 0。这样一来，之前在 IntBuffer 中写入的数据就可以被读取了。
         **/
        intBuffer.flip();
        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }
}
