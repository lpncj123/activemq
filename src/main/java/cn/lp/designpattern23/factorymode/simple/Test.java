package cn.lp.designpattern23.factorymode.simple;

public class Test {
    public static void main(String[] args) {
        Coffee coffee = new CoffeeStore(new AmericanCoffeeFactory()).orderCoffee();
    }
}
