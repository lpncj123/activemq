package cn.lp.cskc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.cskc
 * @Author: lp
 * @CreateTime: 2023-08-01  17:29
 * @Description: TODO
 * @Version: 1.0
 */
public class ThreadDemo {

    public static void main(String[] args) {

        new ThreadDemo().makeThread();
    }

    public void makeThread() {
        AtomicInteger count = new AtomicInteger(0);
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                count.getAndIncrement();
                System.out.println(Thread.currentThread().getName()+"->"+count);
            }

        },"A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                count.getAndIncrement();
                System.out.println(Thread.currentThread().getName()+"->"+count);
            }

        },"B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                count.getAndIncrement();
                System.out.println(Thread.currentThread().getName()+"->"+count);
            }

        },"C").start();

    }
}
