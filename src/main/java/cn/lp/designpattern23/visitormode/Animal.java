package cn.lp.designpattern23.visitormode;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.designpattern23.visitormode
 * @Author: lp
 * @CreateTime: 2023-02-21  11:38
 * @Description: TODO
 * @Version: 1.0
 */
public interface Animal {
    void accept(Person person);
}
