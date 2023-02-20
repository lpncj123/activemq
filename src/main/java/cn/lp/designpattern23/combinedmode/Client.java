package cn.lp.designpattern23.combinedmode;

public class Client {
    public static void main(String[] args) {
        MenuComponent menuComponent = new Menu("粤菜",2);
        MenuComponent menuComponent1 = new MenuItem("红烧狮子头",3);
        menuComponent.add(menuComponent1);
        menuComponent.print();
    }
}
