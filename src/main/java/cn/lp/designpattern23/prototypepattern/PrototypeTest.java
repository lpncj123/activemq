package cn.lp.designpattern23.prototypepattern;

public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Realizetype r1 = new Realizetype();
        Realizetype r2 = (Realizetype) r1.clone();

        System.out.println("对象r1和r2是同一个对象？" + (r1 == r2));
    }
}
