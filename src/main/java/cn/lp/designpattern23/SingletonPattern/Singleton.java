package cn.lp.designpattern23.SingletonPattern;

public class Singleton {
    /**
     * 私有构造方法
     */
    private Singleton() {
        /*
           反射破解单例模式需要添加的代码
           这种方式比较好理解。当通过反射方式调用构造方法进行创建创建时，直接抛异常。不运行此中操作。
        */
//        if(instance != null) {
//            throw new RuntimeException();
//        }
    }
    /**
     * 饿汉式-方式1，静态变量创建类的对象
     */
/*  //在成员位置创建该类的对象
    private static  Singleton instance = new Singleton();
    //静态方法返回该类的对象
    public static  Singleton getInstance(){
        return instance;
    }*/


    /**
     * 饿汉式-方式2（静态代码块方式）
     */
/*    private static  Singleton instance  = null;
    {
        instance = new Singleton();
    }
    public static  Singleton getInstance(){
        return instance;
    }*/






    /**
     * 懒汉式-方式1 线程不安全
     */
/*    private static Singleton instance = null;

    private static Singleton getInstance() {
        if (instance == null) {
            return new Singleton();
        }
        return instance;
    }*/

    /**
     * 懒汉式-方式2 线程安全的（实例对象已经存在，来一个线程都要去竞争锁，造成资源浪费）
     * 该方式也实现了懒加载效果，同时又解决了线程安全问题。但是在getInstance()方法上添加了synchronized关键字，导致该方法的执行效果特别低。
     * 从上面代码我们可以看出，其实就是在初始化instance的时候才会出现线程安全问题，一旦初始化完成就不存在了。
     * 问题是由于线程A判断为空后被系统中断，然后线程B执行实例化完对象A执行，又会创建新的实例对象。
     */

   /* private static Singleton instance = null;

    private static synchronized Singleton getInstance() {
        if (instance == null) {
            return new Singleton();
        }
        return instance;
    }*/


    /**
     * 懒汉式-方式3 双重检验（第一次判断为空，减少了锁的竞争力度。第二次判断为空）
     * 对于 getInstance() 方法来说，绝大部分的操作都是读操作，读操作是线程安全的，所以我们没必让每个线程必须持有锁才能调用该方法，我们需要调整加锁的时机。
     * 由此也产生了一种新的实现模式：双重检查锁模式
     *
     * 双重检查锁模式是一种非常好的单例实现模式，解决了单例、性能、线程安全问题，上面的双重检测锁模式看上去完美无缺，其实是存在问题，
     * 在多线程的情况下，可能会出现空指针问题，出现问题的原因是JVM在实例化对象的时候会进行优化和指令重排序操作。
     *
     * 。这时，如果 instance 未加 volatile 关键字修饰，则会出现指令重排序的问题，即先分配内存空间再进行初始化，此时 instance 不为 null，线程直接返回，而这个时候 instance 对象并没有初始化完成，使用 instance 会出现问题。
     * ‘因此，需要在 instance 前加上 volatile 关键字，来保证线程之间的可见性，从而避免指令重排序的问题。
     *
     * 就是在之前一步规避了所有线程都要抢占锁的问题，但是还存在线程被中断会创建两个单例的问题
     */
   /* private static volatile Singleton instance = null;

    private static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class){
                if(instance==null){
                    return new Singleton();
                }
            }
        }
        return instance;
    }*/


    /**
     * 懒汉式-方式4（静态内部类方式）
     * 静态内部类单例模式中实例由内部类创建，由于 JVM 在加载外部类的过程中, 是不会加载静态内部类的, 只有内部类的属性/方法被调用时才会被加载, 并初始化其静态属性。
     * 静态属性由于被 static 修饰，保证只被实例化一次，并且严格保证实例化顺序。
     *
     * 第一次加载Singleton类时不会去初始化INSTANCE，只有第一次调用getInstance，虚拟机加载SingletonHolder
     *
     * 并初始化INSTANCE，这样不仅能确保线程安全，也能保证 Singleton 类的唯一性。
     *
     * 好处：
     * 线程安全：由于Java的类加载机制保证静态内部类只会被加载一次，因此可以保证该单例实例的线程安全。
     * 懒加载：在SingletonHolder类没有被加载之前，Singleton实例是不会被创建的，因此实现了懒加载的效果，避免了在应用程序启动时就创建对象带来的性能损失。
     * 避免了双重检测带来的复杂性和性能问题：双重检测是为了保证在多线程环境下只创建一次对象，但是这样做会增加代码的复杂性，而且还会存在一些细节问题。Holder模式则通过静态内部类的特性避免了这个问题。
     * 可以防止反射攻击：由于SingletonHolder类的构造方法是私有的，因此无法通过反射来创建新的实例。这对于一些对安全性要求较高的系统来说是非常重要的。
     *
     * 是的，静态内部类在第一次被使用时才会被加载并初始化，因此其内部的单例实例对象也是在第一次使用时才会被创建。这种方式可以避免在单例类加载时就创建实例对象，从而减少内存的浪费。
     * 此外，由于类的加载是线程安全的，因此这种方式也可以保证线程安全。
     */
    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }

    /**
     * 下面是为了解决序列化反序列化破解单例模式
     * 注意：枚举方式不会出现这两个问题。
     */
    private Object readResolve() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 枚举的单例
     */
}
