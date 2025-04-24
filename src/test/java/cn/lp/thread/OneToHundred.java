package cn.lp.thread;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.thread
 * @Author: lp
 * @CreateTime: 2024-04-28  16:37
 * @Description: TODO
 * @Version: 1.0
 */
public class OneToHundred {
    private static final Object lock = new Object();
    private static volatile int count = 0;
    private static final int MAX = 100;

    public static void main(String[] args) {
        new Thread(new seq(0), "A").start();
        new Thread(new seq(1), "B").start();
        new Thread(new seq(2), "C").start();
    }

    static class seq implements Runnable {
        private final int index;

        public seq(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            while (count < MAX) {
                synchronized (lock) {
                    while (count % 3 != index) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (count <= MAX) {
                        System.out.println(Thread.currentThread().getName() + ":" + count);
                    }
                    count++;
                    lock.notifyAll();
                }
            }
        }
    }


}
