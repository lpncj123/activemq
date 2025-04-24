package cn.lp;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionExample {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();

        new Thread(() -> {
            try {
                lock.lock();
                conditionA.await();
                System.out.println("A");
                conditionB.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                lock.lock();
                conditionB.await();
                System.out.println("B");
                conditionC.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                lock.lock();
                conditionC.await();
                System.out.println("C");
                conditionA.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        // 主线程先发出第一个信号，唤醒conditionA
        try {
            lock.lock();
            conditionA.signal();
        } finally {
            lock.unlock();
        }
    }
}
