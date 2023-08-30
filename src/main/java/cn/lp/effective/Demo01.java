package cn.lp.effective;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.effective
 * @Author: lp
 * @CreateTime: 2023-08-23  17:00
 * @Description: TODO
 * @Version: 1.0
 */
// 用静态工厂方法代替构造器 将对象的创建逻辑封装在静态方法中
/*
 优点
 1、有名称
 2、不必在每次调用方法的时候都创建一个新的对象
 3、它们可以返回原类型的任何子类型的对象
 4、所返回的对象的类可以随着每次调用而发生变化，这取决于静态工厂方法的参数值 eg：动物抽象，猫狗继承
 5、方法返回的对象所属的类，在编写包含该静态工厂方法的类时可以不存在 eg：接口方法，实现易扩展，接口里的方法都是抽象的
 缺点
 1、类如果不含公有或者受保护的构造器，就不能被子类化
 2、使用这种方式不注释很难理解
  */
public class Demo01 {
    public static Boolean valueOf(boolean param){
        return param?Boolean.TRUE:Boolean.FALSE;
    }

}
