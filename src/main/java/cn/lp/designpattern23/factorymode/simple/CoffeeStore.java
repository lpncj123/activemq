package cn.lp.designpattern23.factorymode.simple;

public class CoffeeStore {
    private CoffeeFactory factory;
    public CoffeeStore(CoffeeFactory factory) {
        this.factory = factory;
    }

    public Coffee orderCoffee() {
        Coffee coffee = factory.createCoffee();
        coffee.addMilk();
        coffee.addSuger();
        return coffee;
    }
}
