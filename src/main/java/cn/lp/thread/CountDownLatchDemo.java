package cn.lp.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.thread
 * @Author: lp
 * @CreateTime: 2024-01-05  15:49
 * @Description: TODO
 * @Version: 1.0
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        //总数是6
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for(int i=1;i<=6;i++){
            new Thread(()->{
                countDownLatch.countDown();//-1
                System.out.println(Thread.currentThread().getName()+"go out");
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println("Close floor");
    }
}
