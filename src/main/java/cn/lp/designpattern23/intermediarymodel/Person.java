package cn.lp.designpattern23.intermediarymodel;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.designpattern23.intermediarymodel
 * @Author: lp
 * @CreateTime: 2023-02-21  11:01
 * @Description: 抽象同事类
 * @Version: 1.0
 */
public abstract class Person {
    protected String name;
    protected Mediator mediator;

    public Person(String name,Mediator mediator){
        this.name = name;
        this.mediator = mediator;
    }
}
