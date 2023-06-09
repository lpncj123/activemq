package cn.lp;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp
 * @Author: lp
 * @CreateTime: 2023-04-25  17:23
 * @Description: TODO
 * @Version: 1.0
 */
public class ReadLargeFile {
    private static final int BUFFER_SIZE = 1024*1024; // 缓冲区大小为1KB
    private static final int NUM_THREADS = 4; // 使用4个线程处理文件

    public static void main(String[] args) {
        String filePath = "D:\\idea\\a.txt";
        long fileSize = getFileSize(filePath);

        Thread[] threads = new Thread[NUM_THREADS];
        for (int i = 0; i < NUM_THREADS; i++) {
            long start = i * fileSize / NUM_THREADS;
            long end = (i + 1) * fileSize / NUM_THREADS - 1;
            threads[i] = new ProcessorThread(filePath, start, end);
            threads[i].start();
        }
        long startTime = System.currentTimeMillis();  // 记录代码开始执行的时间
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis();  // 记录代码执行结束的时间
        long timeElapsed = endTime - startTime;  // 计算代码执行时间（单位为毫秒）
        System.out.println("代码执行时间为：" + timeElapsed / 1000.0 + "秒");
        System.out.println("File processing completed.");
    }

    private static long getFileSize(String filePath) {
        try {
            //r为只读模式
            return new RandomAccessFile(filePath, "r").length();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static class ProcessorThread extends Thread {
        private final String filePath;
        private final long start;
        private final long end;

        public ProcessorThread(String filePath, long start, long end) {
            this.filePath = filePath;
            this.start = start;
            this.end = end;
        }

        //        @Override
//        public void run() {
//            try (RandomAccessFile file = new RandomAccessFile(filePath, "r")) {
//                FileChannel channel = file.getChannel();
//                ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
//                channel.position(start);
//
//                while (channel.position() <= end) {
//                    buffer.clear();
//                    channel.read(buffer);
//                    buffer.flip();
//
//                    // 对读取到的数据进行处理，这里只是简单地打印出来
//                    while (buffer.hasRemaining()) {
//                        System.out.print(buffer.get());
//                    }
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        @Override
        public void run() {
            try (RandomAccessFile file = new RandomAccessFile(filePath, "r")) {
                FileChannel channel = file.getChannel();
                ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
                channel.position(start);

                while (channel.read(buffer) != -1 && channel.position() <= end) {
                    buffer.flip();
                    //是的，buffer.hasRemaining()方法的作用是判断缓冲区中是否还有未读取的数据。如果有，返回true；如果没有，返回false。可以根据这个方法来判断是否需要继续读取缓冲区中的数据。
                    while (buffer.hasRemaining()) {
                        byte[] bytes = new byte[buffer.remaining()];
                        System.out.print(buffer.get(bytes));
                    }
                    buffer.clear();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
