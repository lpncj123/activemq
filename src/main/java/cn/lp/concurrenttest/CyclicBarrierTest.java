package cn.lp.concurrenttest;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.concurrentart
 * @Author: lp
 * @CreateTime: 2023-11-16  15:43
 * @Description: TODO
 * @Version: 1.0
 */
public class CyclicBarrierTest {
    static CyclicBarrier c = new CyclicBarrier(2,new A());

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        new Thread(() -> {
            try {
                c.await();
            } catch (Exception e) {
            }
            System.out.println(1);
        }).start();
        c.await();
        System.out.println(2);
    }
    static class A implements Runnable{
        @Override
        public void run() {
            System.out.println(3);
        }
    }
}
