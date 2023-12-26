package cn.lp.concurrenttest;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.concurrentart
 * @Author: lp
 * @CreateTime: 2023-10-17  17:12
 * @Description: TODO
 * @Version: 1.0
 */
public class ConcurrentTest {
    private static final long count = 100;

    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }

    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(
            () -> {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a += 5;
                }
            }
        );
        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        thread.join();
        System.out.println(System.currentTimeMillis() - start + "***" + b);

    }

    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        System.out.println("serial" + (System.currentTimeMillis() - start) + "***" + b + "***" + a);

    }
}
