package cn.lp.designpattern23.intermediarymodel;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.designpattern23.intermediarymodel
 * @Author: lp
 * @CreateTime: 2023-02-21  10:53
 * @Description: 抽象中介者
 * @Version: 1.0
 */
public abstract class Mediator {
    /**
     * @description: 申明一个联络方法
     * @author: lp
     * @date: 2023/2/21 11:01
     * @param: [message, person]
     * @return: void
     **/
    public abstract void constact(String message, Person person);
}
