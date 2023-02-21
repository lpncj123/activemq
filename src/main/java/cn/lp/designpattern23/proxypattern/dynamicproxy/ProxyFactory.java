package cn.lp.designpattern23.proxypattern.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    private TrainStation station = new TrainStation();

    public SellTickets getProxyObject() {
        //使用Proxy获取代理对象
        /*
            newProxyInstance()方法参数说明：
                ClassLoader loader ： 类加载器，用于加载代理类，使用真实对象的类加载器即可
                Class<?>[] interfaces ： 真实对象所实现的接口，代理模式真实对象和代理对象实现相同的接口
                InvocationHandler h ： 代理对象的调用处理程序
         */
        SellTickets sellTickets = (SellTickets) Proxy.newProxyInstance(station.getClass().getClassLoader(),
            station.getClass().getInterfaces(),
            new InvocationHandler() {
                /*
                    InvocationHandler中invoke方法参数说明：
                        proxy ： 代理对象
                        method ： 对应于在代理对象上调用的接口方法的 Method 实例
                        args ： 代理对象调用接口方法时传递的实际参数
                 */
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                    System.out.println("代理点收取一些服务费用(JDK动态代理方式)");
                    //执行真实对象
                    Object result = method.invoke(station, args);
                    return result;
                }
            });
        return sellTickets;
    }
}
/**
 * 程序运行过程中动态生成的代理类
 */
/*public final class $Proxy0 extends Proxy implements SellTickets {
    private static Method m3;

    public $Proxy0(InvocationHandler invocationHandler) {
        super(invocationHandler);
    }

    static {
        m3 = Class.forName("com.itheima.proxy.dynamic.jdk.SellTickets").getMethod("sell", new Class[0]);
    }

    public final void sell() {
        this.h.invoke(this, m3, null);
    }
}*/
/**
 * 在测试类中通过代理对象调用sell()方法
 * 根据多态的特性，执行的是代理类（$Proxy0）中的sell()方法
 * 代理类（$Proxy0）中的sell()方法中又调用了InvocationHandler接口的子实现类对象的invoke方法
 * invoke方法通过反射执行了真实对象所属类(TrainStation)中的sell()方法
 */