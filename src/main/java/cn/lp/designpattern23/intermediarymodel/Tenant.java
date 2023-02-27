package cn.lp.designpattern23.intermediarymodel;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.designpattern23.intermediarymodel
 * @Author: lp
 * @CreateTime: 2023-02-21  11:03
 * @Description: 具体同事类 承租人
 * @Version: 1.0
 */
public class Tenant  extends Person {
    public Tenant(String name, Mediator mediator) {
        super(name, mediator);
    }

    //与中介者联系
    public void constact(String message){
        mediator.constact(message, this);
    }

    //获取信息
    public void getMessage(String message){
        System.out.println("租房者" + name +"获取到的信息：" + message);
    }
}
