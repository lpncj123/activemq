package cn.lp.concurrentart;

import cn.lp.utils.SleepUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.concurrentart
 * @Author: lp
 * @CreateTime: 2023-10-27  15:08
 * @Description: TODO
 * @Version: 1.0
 */
public class Deprecated {
    public static void main(String[] args) throws InterruptedException {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Thread printThread = new Thread(new Runner(), "PrintThread");
        printThread.setDaemon(true);
        printThread.start();
        TimeUnit.SECONDS.sleep(3);
        printThread.suspend();
        System.out.println("suspend:"+dateFormat.format(new Date()));
        TimeUnit.SECONDS.sleep(3);
        printThread.resume();
        System.out.println("resume:"+dateFormat.format(new Date()));
        TimeUnit.SECONDS.sleep(3);
        printThread.stop();
        System.out.println("stop:"+dateFormat.format(new Date()));
        TimeUnit.SECONDS.sleep(3);
    }
    static class Runner implements Runnable{
        @Override
        public void run() {
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            while (true){
                System.out.println(Thread.currentThread().getName()+"Run at"+ dateFormat.format(new Date()));
                SleepUtils.sleep(1);
            }
        }
    }
}
