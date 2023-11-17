package cn.lp.concurrentart;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.concurrentart
 * @Author: lp
 * @CreateTime: 2023-11-16  11:03
 * @Description: TODO
 * @Version: 1.0
 */
public class AtomicReferenceTest {
    public static AtomicReference<User> atomicReference = new AtomicReference<>();

    public static void main(String[] args) {
        User tom = new User("Tom", 11);
        atomicReference.set(tom);
        User snc = new User("snc", 12);
        atomicReference.compareAndSet(tom,snc);
        System.out.println(atomicReference.get().getName()+"**"+atomicReference.get().getOld());
    }
    static  class  User{
        private String name;
        private  int old;

        public User(String name, int old) {
            this.name = name;
            this.old = old;
        }

        public String getName() {
            return name;
        }

        public int getOld() {
            return old;
        }

    }
}
