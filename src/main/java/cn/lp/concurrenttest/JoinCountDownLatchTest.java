package cn.lp.concurrenttest;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.concurrentart
 * @Author: lp
 * @CreateTime: 2023-11-16  11:23
 * @Description: TODO
 * @Version: 1.0
 */
public class JoinCountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("thread1 finish");
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("thread2 finish");
        });
        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
        System.out.println("全部完成");
    }
}
