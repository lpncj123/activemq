package cn.lp.cskc.threadott;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.cskc.threadott
 * @Author: lp
 * @CreateTime: 2023-08-01  18:21
 * @Description: TODO
 * @Version: 1.0
 */
public class ThreadOttExecuteSycn {
    private static final Object lock = new Object();
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            synchronized (lock){
                System.out.println(Thread.currentThread().getName());
            }

        },"A");

        Thread t2 = new Thread(()->{
            synchronized (lock){
                System.out.println(Thread.currentThread().getName());
            }
        },"B");

        Thread t3 = new Thread(()->{
            synchronized (lock){
                System.out.println(Thread.currentThread().getName());
            }
        },"C");
        t1.start();
        t2.start();
        t3.start();
    }
}
