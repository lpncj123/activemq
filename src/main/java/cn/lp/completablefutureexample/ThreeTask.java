package cn.lp.completablefutureexample;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.completablefutureexample
 * @Author: lp
 * @CreateTime: 2024-05-21  16:44
 * @Description: TODO
 * @Version: 1.0
 */
public class ThreeTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CompletableFuture future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务1线程" + Thread.currentThread().getId());
            int i = 10 / 4;
            System.out.println("任务1结束：");
            return i;
        }, executor);

        CompletableFuture future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务2线程" + Thread.currentThread().getId());
            try {
                Thread.sleep(3000);
                System.out.println("任务2结束：");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        },executor);
        // runAfterBothAsync：任务01 任务02都完成了，再开始执行任务3，不感知任务1、2的结果的，也没返回值
        future1.runAfterBothAsync(future2, () -> {
            System.out.println("任务3线程" + Thread.currentThread().getId());
        },executor);

        // thenAcceptBothAsync：任务01 任务02都完成了，再开始执行任务3，能感知到任务1、2的结果，但没返回值
        future1.thenAcceptBothAsync(future2, (f1, f2) -> {
            System.out.println("任务3线程" + Thread.currentThread().getId());
            System.out.println("任务3结束：" + f1 + " " + f2);
        },executor);
        // thenCombineAsync：任务01 任务02都完成了，再开始执行任务3，能感知到任务1、2的结果，而且自己可以带返回值
        CompletableFuture completableFuture = future1.thenCombineAsync(future2, (f1, f2) -> {
            return f1 + " " + f2;
        }, executor);

        //runAfterEitherAsync：两个任务只要有一个完成，就执行任务3，不感知结果，自己没返回值
        future1.runAfterEitherAsync(future2, () -> {
            System.out.println("任务3开始...");
        },executor);
        //acceptEitherAsync：两个任务只要有一个完成，就执行任务3，感知结果，自己没返回值
        future1.acceptEitherAsync(future2, (f) -> {
            System.out.println("任务3开始...之前的结果" + f);
        },executor);

        //applyToEitherAsync：两个任务只要有一个完成，就执行任务3，感知结果，自己有返回值
        CompletableFuture<String> completableFuture1 = future1.applyToEitherAsync(future2, (f) -> {
            return f + "任务3";
        },executor);
        System.out.println(completableFuture.get()+"***"+completableFuture1.get());
    }
}
