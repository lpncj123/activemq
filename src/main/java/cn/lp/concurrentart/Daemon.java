package cn.lp.concurrentart;

import cn.lp.utils.SleepUtils;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.concurrentart
 * @Author: lp
 * @CreateTime: 2023-10-26  18:02
 * @Description: TODO
 * @Version: 1.0
 */
public class Daemon {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }
    static class DaemonRunner implements Runnable{
        @Override
        public void run() {
            try {
                SleepUtils.sleep(1);
            }finally {
                System.out.println("Daemon finally run");
            }

        }
    }
}
