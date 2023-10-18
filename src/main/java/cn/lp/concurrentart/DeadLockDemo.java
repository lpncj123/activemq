package cn.lp.concurrentart;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.concurrentart
 * @Author: lp
 * @CreateTime: 2023-10-18  17:55
 * @Description: TODO
 * @Version: 1.0
 */
public class DeadLockDemo {
    private  static  String A = "A";
    private  static  String B = "B";

    public static void main(String[] args) {
        DeadLockDemo.deadLock();
    }
    public static  void deadLock(){
        Thread t1 = new Thread(()->{
            synchronized (A){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B){
                    System.out.println("t1锁了B");
                }
            }
        });
        Thread t2 = new Thread(()->{
            synchronized (B){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (A){
                    System.out.println("t2锁了A");
                }
            }
        });
        t1.start();
        t2.start();
    }
}
