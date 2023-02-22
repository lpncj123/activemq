package cn.lp.designpattern23.visitormode;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.designpattern23.visitormode
 * @Author: lp
 * @CreateTime: 2023-02-21  11:42
 * @Description: TODO
 * @Version: 1.0
 */
public class Home {
    private List<Animal> nodeList = new ArrayList<>();

    public void action(Person person) {
        for (Animal node : nodeList) {
            node.accept(person);
        }
    }

    //添加操作
    public void add(Animal animal) {
        nodeList.add(animal);
    }
}
