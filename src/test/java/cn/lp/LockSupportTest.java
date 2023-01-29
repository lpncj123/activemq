package cn.lp;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //没有返回值runAsync 亦不会调
        //这里的意思：当前线程需要两秒的时间计算，但是如果不想等待2秒的时间，还可以执行下面的代码，到了get方法取值的时候，如果已经过了两秒后，方法执行完了，可以直接得到值，不然线程会在得到值的地方阻塞，直到获取到值。往下执行
//        CompletableFuture<Void> future = CompletableFuture.runAsync(()->{
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName()+"runAs");
//        });
//        System.out.println("11111");
//        try {
//            future.get();//获取阻塞执行结果
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
        //有返回值的supplyAsync 异步回调
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()->{
            int i = 1024/0;
            return 1024;
        });
        System.out.println("11111");

        System.out.println(future.whenComplete((t, u) -> {
            System.out.println(t + "*****" + u);// t 正常的返回结果 // u 错误的信息
        }).exceptionally((e) -> {
            System.out.println(e.getMessage());
            return 404; //可以获取到错误的返回结果
        }).get());
        future.get();
    }
    private static void lockSupportParkUnpark() {
        Thread a = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t" + "------come in" + System.currentTimeMillis());
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "\t" + "------被唤醒" + System.currentTimeMillis());
        }, "A");
        a.start();

        new Thread(() -> {
            LockSupport.unpark(a);
            System.out.println(Thread.currentThread().getName() + "\t" + "------通知");
        }, "B").start();
    }
    private static void lockSupportParkUnpark1() {
        Thread a = new Thread(() -> {

            System.out.println(Thread.currentThread().getName() + "\t" + "------come in");
            LockSupport.park(); // 线程 A 阻塞
            System.out.println(Thread.currentThread().getName() + "\t" + "------被唤醒");
        }, "A");
        a.start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.unpark(a); // B 线程唤醒线程 A
            System.out.println(Thread.currentThread().getName() + "\t" + "------通知");
        }, "B").start();
    }
    static Thread t1 =null,t2=null;
    private static  void charTest(){
        final Object o = new Object();
        char[] a1 = "123456".toCharArray();
        char[] a2 = "ABCDEF".toCharArray();

        t1 = new Thread(()->{
            for (char c : a1) {
                System.out.println(c);
                LockSupport.unpark(t2);
                LockSupport.park();

            }
        },"t1");
        t2 = new Thread(()->{
            for (char c : a2) {
                LockSupport.park();
                System.out.println(c);
                LockSupport.unpark(t1);
            }
        },"t2");
        t1.start();
        t2.start();
    }
}
