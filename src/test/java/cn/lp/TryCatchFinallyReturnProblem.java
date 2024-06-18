package cn.lp;

import javax.validation.constraints.NotNull;
import java.util.concurrent.*;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp
 * @Author: lp
 * @CreateTime: 2024-04-10  16:43
 * @Description: TODO
 * @Version: 1.0
 */
public class TryCatchFinallyReturnProblem extends Thread{

    public static int returnTest() {
        int i = 0;
        try {
            i++;
            return i;
        } catch (Exception e) {
            i = 66;
        } finally {
            i = 100;
        }
        return i;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
//        System.out.println(TryCatchFinallyReturnProblem.returnTest());

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 5, 1000, TimeUnit.MINUTES, new ArrayBlockingQueue<>(3), new ThreadFactory() {
            @Override
            public Thread newThread(@NotNull Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("MyThread");
                return thread;
            }
        });
        Future<String> future1 = threadPoolExecutor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("线程执行中");
                return "1";
            }
        });
        String a = future1.get();
        System.out.println(a);

    }
}