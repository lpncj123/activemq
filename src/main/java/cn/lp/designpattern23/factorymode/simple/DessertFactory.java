package cn.lp.designpattern23.factorymode.simple;

/**
 * 可以根据产品不同分类（美式，意式）
 */
public interface DessertFactory {
    Coffee createCoffee();

    Dessert createDessert();
}
