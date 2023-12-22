package cn.lp.concurrenttest;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.concurrentart
 * @Author: lp
 * @CreateTime: 2023-10-27  15:56
 * @Description: TODO
 * @Version: 1.0
 */
public class Synchronized {
    public static void main(String[] args) {
        synchronized (Synchronized.class){
        }
        m();
    }
    public static synchronized void m(){

    }
}
