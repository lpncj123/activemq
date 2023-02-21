package cn.lp.designpattern23.commandmode;

// 资深大厨类 是命令的Receiver
public class SeniorChef {
    public void makeFood(int num,String foodName) {
        System.out.println(num + "份" + foodName);
    }
}
