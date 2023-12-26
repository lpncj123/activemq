package cn.lp.concurrenttest;

import java.util.concurrent.TimeUnit;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.concurrentart
 * @Author: lp
 * @CreateTime: 2023-10-27  15:26
 * @Description: TODO
 * @Version: 1.0
 */
public class Shutdown {
    public static void main(String[] args) throws InterruptedException {
        Runner one = new Runner();
        Thread countThread = new Thread(one, "CountThread");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();
        Runner two = new Runner();
        countThread = new Thread(two, "CountThread");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        two.cancel();
    }

    private static class Runner implements Runnable {
        private long i;
        private volatile boolean on = true;

        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("Count i =" + i);
        }

        public void cancel() {
            on = false;
        }
    }
}
