package cn.lp.concurrenttest;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.concurrentart
 * @Author: lp
 * @CreateTime: 2023-11-13  18:20
 * @Description: TODO
 * @Version: 1.0
 */
public class AtomicIntegerArrayTest {
    static int[] value = new int[]{1,2};
    static AtomicIntegerArray ai = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        ai.getAndSet(0,3);
        System.out.println(ai.get(0));
        System.out.println(value[0]);
    }
}
