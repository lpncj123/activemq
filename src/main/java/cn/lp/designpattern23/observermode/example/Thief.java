package cn.lp.designpattern23.observermode.example;

import java.util.Observable;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.designpattern23.observermode.example
 * @Author: lp
 * @CreateTime: 2023-02-21  10:45
 * @Description:
 * 警察抓小偷也可以使用观察者模式来实现，警察是观察者，小偷是被观察者。代码如下：
 * 小偷是一个被观察者，所以需要继承Observable类
 * @Version: 1.0
 */
public class Thief extends Observable {
    private String name;

    public Thief(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void steal() {
        System.out.println("小偷：我偷东西了，有没有人来抓我！！！");
        super.setChanged(); //changed  = true
        super.notifyObservers();
    }
}
