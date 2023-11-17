package cn.lp.concurrentart;

import java.util.concurrent.*;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.concurrentart
 * @Author: lp
 * @CreateTime: 2023-11-17  17:38
 * @Description: TODO
 * @Version: 1.0
 */
public class ThreadPoolExecutorTest {
    static ExecutorService executorService = Executors.newFixedThreadPool(2);
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//       Callable<Integer> callable = new Callable<Integer>() {
//           @Override
//           public Integer call() throws Exception {
//               return 11;
//           }
//       };
//
//        Future<Integer> submit = executorService.submit(callable);
//
//        System.out.println(submit.get());
//        executorService.shutdown();
        Runnable runnable = ()->{
            System.out.println("我执行完了");
        };
        Callable<String> callable = Executors.callable(runnable, "111");
        Future<String> submit = executorService.submit(callable);
        System.out.println(submit.get());
    }

}
