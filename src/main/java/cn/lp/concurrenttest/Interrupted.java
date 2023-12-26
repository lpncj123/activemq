package cn.lp.concurrenttest;

import cn.lp.utils.SleepUtils;

import java.util.concurrent.TimeUnit;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.concurrentart
 * @Author: lp
 * @CreateTime: 2023-10-27  11:35
 * @Description: TODO
 * @Version: 1.0
 */
public class Interrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread sleepThread = new Thread(new SleepThread(), "SleepThread");
        sleepThread.setDaemon(true);
        Thread busyThread = new Thread(new BusyThread(), "BusyThread");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();
        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("sleepThread:"+sleepThread.isInterrupted());
        System.out.println("busyThread:"+busyThread.isInterrupted());
        SleepUtils.sleep(2);
    }

    static class SleepThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                SleepUtils.sleep(10);
            }
        }
    }
    static class BusyThread implements Runnable{
        @Override
        public void run() {
            while(true){

            }
        }
    }
}
