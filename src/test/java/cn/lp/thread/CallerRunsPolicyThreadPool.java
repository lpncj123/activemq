package cn.lp.thread;

import java.util.concurrent.*;

import static cn.lp.utils.SleepUtils.sleep;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.thread
 * @Author: lp
 * @CreateTime: 2025-12-26  17:00
 * @Description: TODO 线程池拒绝策略之丢弃最旧的任务策略示例以及 submit 方法捕获异常示例以及 isAlive 和 join 方法示例
 * @Version: 1.0
 */
public class CallerRunsPolicyThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 60L,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(1),
            new ThreadPoolExecutor.DiscardOldestPolicy  ());
        System.out.println("主线程开始提交任务");

// 任务1
        threadPoolExecutor.execute(() -> {
            System.out.println("任务1 在线程: " + Thread.currentThread().getName() + " 执行");
            sleep(2);
        });

// 任务2
        threadPoolExecutor.execute(() -> {
            System.out.println("任务2 在线程: " + Thread.currentThread().getName() + " 执行");
            sleep(2);
        });

// 任务3
        threadPoolExecutor.execute(() -> {
            System.out.println("任务3 在线程: " + Thread.currentThread().getName() + " 执行");
            sleep(2);
        });

// 任务4（关键！）
        threadPoolExecutor.execute(() -> {
            System.out.println("任务4 在线程: " + Thread.currentThread().getName() + " 执行");
            sleep(2);
        });

        System.out.println("主线程提交完毕，继续干其他事");

        Future<Object> testEx = threadPoolExecutor.submit(() -> {
            throw new RuntimeException("测试异常");
        });
        try {
            Object o = testEx.get();
            System.out.println(o);
        } catch (ExecutionException e) {
            System.out.println("捕获到异常: " + e.getCause().getMessage());

        }

        Thread t1 = new Thread(() -> {
            System.out.println("t1 begin");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println("t1 end");
        });
        t1.start();
        System.out.println("t1.isAlive()="+t1.isAlive());
        t1.join();
        System.out.println("t1.isAlive()="+t1.isAlive());
        threadPoolExecutor.shutdown();
    }
}
