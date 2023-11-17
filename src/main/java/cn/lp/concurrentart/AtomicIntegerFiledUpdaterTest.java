package cn.lp.concurrentart;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.concurrentart
 * @Author: lp
 * @CreateTime: 2023-11-16  11:13
 * @Description: TODO
 * @Version: 1.0
 */
public class AtomicIntegerFiledUpdaterTest {
//    需要设置更新的对象和需要更新的属性
    private static AtomicIntegerFieldUpdater<User> a = AtomicIntegerFieldUpdater.newUpdater(User.class,"old");

    public static void main(String[] args) {
        User user = new User("a", 1);
//        这里会输出旧的年龄
        System.out.println(a.getAndIncrement(user));
//        输出现在的年龄
        System.out.println(a.get(user));
    }
    public static class User{
        private String name;
        public volatile int old;

        public String getName() {
            return name;
        }

        public int getOld() {
            return old;
        }

        public User(String name, int old) {
            this.name = name;
            this.old = old;
        }
    }
}
