package cn.lp.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class ReenLock {
    static Lock lock = new ReentrantLock();
    public static void main(String[] args) {
//        lock.lock();
       ReenLock.test1();
    }

    public static void test1(){
        Thread a = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "------come in");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread.currentThread().interrupt();
            LockSupport.park(); // 线程 A 阻塞
            System.out.println(Thread.currentThread().getName() + "\t" + "------被打断唤醒");
        }, "A");

        a.start();
        a.interrupt();
//        new Thread(() -> {
//          LockSupport.unpark(a);
//          System.out.println(Thread.currentThread().getName() + "\t" + "------通知");
//        }, "B").start();

    }
}
