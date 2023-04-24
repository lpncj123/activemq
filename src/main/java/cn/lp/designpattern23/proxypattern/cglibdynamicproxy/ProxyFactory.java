package cn.lp.designpattern23.proxypattern.cglibdynamicproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
/**
 MethodInterceptor是CGLib动态代理中的一个接口，它定义了CGLib代理对象的方法拦截器。在使用CGLib动态代理技术创建代理对象时，我们需要实现MethodInterceptor接口，并在其中实现代理逻辑。具体来说，MethodInterceptor接口的作用包括以下几个方面：
 拦截目标对象的方法调用：MethodInterceptor接口的intercept方法用于拦截目标对象的方法调用。在这个方法中，我们可以获取代理对象、目标对象、方法对象和方法参数，并根据需要对这些对象进行处理。
 实现代理逻辑：MethodInterceptor接口的intercept方法中可以实现代理逻辑，例如在目标方法调用前后打印日志、修改方法参数、缓存方法调用结果等。
 返回代理对象的方法调用结果：MethodInterceptor接口的intercept方法需要返回方法调用的结果。如果目标方法有返回值，则intercept方法返回目标方法的返回值；如果目标方法没有返回值，则intercept方法返回null。
 控制方法调用的流程：MethodInterceptor接口的intercept方法可以控制方法调用的流程。例如，我们可以在方法调用前判断是否要执行目标方法，或者在方法调用后判断是否要抛出异常。
 **/
public class ProxyFactory implements MethodInterceptor {

    private TrainStation target = new TrainStation();

    public TrainStation getProxyObject() {
        //创建Enhancer对象，类似于JDK动态代理的Proxy类，下一步就是设置几个参数
        Enhancer enhancer =new Enhancer();
        //设置父类的字节码对象，设置代理对象的父类，也是需要代理目标对象
        /**
         * enhancer.setSuperclass(target.getClass())是CGLib动态代理中的一行代码，它用于设置代理对象的父类。
         * 在这里，target是指目标对象，而target.getClass()则是获取目标对象的类对象。
         * 因此，enhancer.setSuperclass(target.getClass())的作用就是将目标对象的类对象作为代理对象的父类，从而让代理对象可以继承目标对象的非final方法，并实现对目标对象方法的代理。
         **/
        enhancer.setSuperclass(target.getClass());
        //设置回调函数
        /**
         * 在这里，this指的是当前对象，也就是 ProxyFactory 类的实例对象。
         * 在 ProxyFactory 类中实现了 MethodInterceptor 接口，所以可以使用 this 作为回调函数。
         * 当代理对象的方法被调用时，会触发 this 的 intercept() 方法。
         * 因此，将 this 传递给 enhancer.setCallback() 方法，实际上是将当前对象的 intercept() 方法设置为代理对象的回调函数。
         * 这样，在代理对象方法被调用时，就会执行当前对象的 intercept() 方法。
         * 在使用enhancer.setCallback(this)时，CGLib动态代理技术体现了继承的特点，代理对象是继承了目标对象的子类，并重写了目标对象的非final方法。
         */
        enhancer.setCallback(this);
        //创建代理对象
        /**
         *  当我们调用enhancer.create方法创建代理对象时，CGLib会动态生成一个代理对象的子类，并将目标对象的类对象作为该代理对象子类的父类。
         *  在子类中，CGLib会重写目标对象的非final方法，并在这些方法中调用MethodInterceptor对象的intercept方法，完成代理操作。
         **/
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
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("代理点收取一些服务费用(CGLIB动态代理方式)");
        //执行父类的方法
        methodProxy.invokeSuper(o, args);
        return null;
    }
}