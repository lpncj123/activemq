package cn.lp.completablefutureexample;

import java.util.concurrent.*;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.completablefutureexample
 * @Author: lp
 * @CreateTime: 2024-05-21  16:11
 * @Description: TODO
 * @Version: 1.0
 */
public class SingleTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CompletableFuture completableFuture =CompletableFuture.runAsync(()->{
            System.out.println("当前线程"+Thread.currentThread().getId());
            int i  = 10/2;
            System.out.println("运行结果"+i);
        },executor);
        executor.shutdown();
    }

}
