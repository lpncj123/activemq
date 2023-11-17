package cn.lp.concurrentart;

import java.util.concurrent.CountDownLatch;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.concurrentart
 * @Author: lp
 * @CreateTime: 2023-11-16  11:29
 * @Description: TODO
 * @Version: 1.0
 */
public class CountDownLatchTest {
    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            System.out.println("Thread1 start");
            c.countDown();
        }).start();
        new Thread(()->{
            System.out.println("Thread2 start");
            c.countDown();
        }).start();
        c.await();
        System.out.println(3);
    }
}
