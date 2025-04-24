package cn.lp.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.thread
 * @Author: lp
 * @CreateTime: 2024-01-05  15:48
 * @Description: TODO
 * @Version: 1.0
 */
public class CycliBarrierDemo {
    public static void main(String[] args) {
        /**
         * 集齐7颗龙珠召唤神龙
         */
        //召唤龙珠的线程
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("成功");
        });
        for (int i = 1; i <= 7; i++) {
            final int temp = i;
            //lambda能操作到i吗
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"收集"+temp);
                try {
                    cyclicBarrier.await(); //等待
                    System.out.println("开心，哈哈哈"+temp);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
