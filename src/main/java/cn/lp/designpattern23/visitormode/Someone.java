package cn.lp.designpattern23.visitormode;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.designpattern23.visitormode
 * @Author: lp
 * @CreateTime: 2023-02-21  11:43
 * @Description: TODO
 * @Version: 1.0
 */
public class Someone implements Person{
    @Override
    public void feed(Cat cat) {
        System.out.println("其他人喂食猫");
    }

    @Override
    public void feed(Dog dog) {
        System.out.println("其他人喂食狗");
    }
}
