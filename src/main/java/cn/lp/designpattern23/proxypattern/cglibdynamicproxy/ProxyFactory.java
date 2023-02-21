package cn.lp.designpattern23.proxypattern.cglibdynamicproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {

    private TrainStation target = new TrainStation();

    public TrainStation getProxyObject() {
        //创建Enhancer对象，类似于JDK动态代理的Proxy类，下一步就是设置几个参数
        Enhancer enhancer =new Enhancer();
        //设置父类的字节码对象
        enhancer.setSuperclass(target.getClass());
        //设置回调函数
        /**
         * 在这里，this指的是当前对象，也就是 ProxyFactory 类的实例对象。
         * 在 ProxyFactory 类中实现了 MethodInterceptor 接口，所以可以使用 this 作为回调函数。
         * 当代理对象的方法被调用时，会触发 this 的 intercept() 方法。
         * 因此，将 this 传递给 enhancer.setCallback() 方法，实际上是将当前对象的 intercept() 方法设置为代理对象的回调函数。
         * 这样，在代理对象方法被调用时，就会执行当前对象的 intercept() 方法。
         */
        enhancer.setCallback(this);
        //创建代理对象
        TrainStation obj = (TrainStation) enhancer.create();
        return obj;
    }

    /*
        intercept方法参数说明：
            o ： 代理对象
            method ： 真实对象中的方法的Method实例
            args ： 实际参数
            methodProxy ：代理对象中的方法的method实例
     */
    @Override
    public TrainStation intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("代理点收取一些服务费用(CGLIB动态代理方式)");
        TrainStation result = (TrainStation) methodProxy.invokeSuper(o, args);
        return result;
    }
}