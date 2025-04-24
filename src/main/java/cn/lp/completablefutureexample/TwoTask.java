package cn.lp.completablefutureexample;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.completablefutureexample
 * @Author: lp
 * @CreateTime: 2024-05-21  16:37
 * @Description: TODO
 * @Version: 1.0
 */
public class TwoTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture.supplyAsync(() -> {
//            System.out.println("当前线程" + Thread.currentThread().getId());
//            int i = 10 / 4;
//            System.out.println("运行结果：" + i);
//            return i;
////            thenRunAsync：不能接收上一次的执行结果，也没返回值
//        }).thenRunAsync(() -> {
//            System.out.println("任务2启动了...");
//        });

        ExecutorService executor = Executors.newFixedThreadPool(3);
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程" + Thread.currentThread().getId());
            int i = 10 / 4;
            System.out.println("运行结果：" + i);
            return i;
//            thenRunAsync：不能接收上一次的执行结果，也没返回值
        }, executor).thenApplyAsync((res) -> {
            System.out.println("任务2启动了..." + res);
            return "hello " + res;
        }, executor);
        System.out.println(completableFuture.get());

        executor.shutdown();
    }
}
