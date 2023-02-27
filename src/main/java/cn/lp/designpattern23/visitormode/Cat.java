package cn.lp.designpattern23.visitormode;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.designpattern23.visitormode
 * @Author: lp
 * @CreateTime: 2023-02-21  11:38
 * @Description: TODO
 * @Version: 1.0
 */
public class Cat implements Animal{
    @Override
    public void accept(Person person) {
        person.feed(this);
        System.out.println("好好吃，喵喵喵！！！");
    }
}
