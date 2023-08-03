package cn.lp.cskc.threadott;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.cskc
 * @Author: lp
 * @CreateTime: 2023-08-01  17:52
 * @Description: TODO
 * @Version: 1.0
 */
public class ThreadOttExecute {
    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        },"A");

        Thread t2 = new Thread(()->{
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        },"B");

        Thread t3 = new Thread(()->{
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        },"C");
        t1.start();
        t2.start();
        t3.start();
    }
}
