package cn.lp.designpattern23.visitormode;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.designpattern23.visitormode
 * @Author: lp
 * @CreateTime: 2023-02-21  11:37
 * @Description: TODO
 * @Version: 1.0
 */
public interface Person {
    void feed(Cat cat);

    void feed(Dog dog);
}
