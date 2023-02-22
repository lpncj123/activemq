package cn.lp.designpattern23.observermode.example;

import java.util.Observable;
import java.util.Observer;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.designpattern23.observermode.example
 * @Author: lp
 * @CreateTime: 2023-02-21  10:46
 * @Description: TODO
 * @Version: 1.0
 */
public class Policemen implements Observer {

    private String name;

    public Policemen(String name) {
        this.name = name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("警察：" + ((Thief) o).getName() + "，我已经盯你很久了，你可以保持沉默，但你所说的将成为呈堂证供！！！");
    }
}
