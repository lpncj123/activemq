package cn.lp.designpattern23.observermode.example;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.designpattern23.observermode.example
 * @Author: lp
 * @CreateTime: 2023-02-21  10:46
 * @Description:
 * Observable 类是抽象目标类（被观察者），它有一个 Vector 集合成员变量，用于保存所有要通知的观察者对象，下面来介绍它最重要的 3 个方法。
 * void addObserver(Observer o) 方法：用于将新的观察者对象添加到集合中。
 * void notifyObservers(Object arg) 方法：调用集合中的所有观察者对象的 update方法，通知它们数据发生改变。通常越晚加入集合的观察者越先得到通知。
 * void setChange() 方法：用来设置一个 boolean 类型的内部标志，注明目标对象发生了变化。当它为true时，notifyObservers() 才会通知观察者。
 * @Version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        //创建小偷对象
        Thief t = new Thief("隔壁老王");
        //创建警察对象
        Policemen p = new Policemen("小李");
        //让警察盯着小偷
        t.addObserver(p);
        //小偷偷东西
        t.steal();
    }
}
