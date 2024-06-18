package cn.lp.completablefutureexample;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * supplyAsync有返回值
 * whenComplete能感知异常，能感知结果，但没办法给返回值
 * exceptionally能感知异常，不能感知结果，能给返回值。相当于，如果出现异常就返回这个值
 */
public class SingleTaskAndReturn {
//    有返回值之whenComplete和exceptionally
    public static void main(String[] args) throws ExecutionException, InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程" + Thread.currentThread().getId());
            int i = 10 / 0;
            System.out.println("运行结果：" + i);
            return i;
        },executor).whenComplete( (t,u) -> {
            //whenComplete虽然能得到异常信息，但是没办法修改返回值
            if (u != null) {
                System.out.println("异步任务出现异常：" + u.getMessage());
            } else {
                System.out.println("异步任务成功，结果是：" + t);
            }
        }).exceptionally(e -> {
            //exceptionally能感知异常，而且能返回一个默认值，相当于，如果出现异常就返回这个值
            System.out.println("异常情况：" + e.getMessage());
            return 10;
        });
        executor.shutdown();
    }

//    //handle能拿到返回结果，也能得到异常信息，也能修改返回值
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> {
//            System.out.println("当前线程" + Thread.currentThread().getId());
//            int i = 10 / 2;
//            System.out.println("运行结果：" + i);
//            return i;
//        }).handle((t, u) -> {
//            if (u != null) {
//                System.out.println("异步任务出现异常：" + u.getMessage());
//                return 0;
//            } else {
//                System.out.println("异步任务成功，结果是：" + t);
//            }
//            return t*2;
//        });
//        System.out.println(completableFuture.get());
//    }
}
