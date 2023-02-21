package cn.lp.designpattern23.factorymode.simple;

public interface CoffeeFactory {
    /**
     * 制造咖啡
     * @return Coffee
     */
    Coffee createCoffee();
}
