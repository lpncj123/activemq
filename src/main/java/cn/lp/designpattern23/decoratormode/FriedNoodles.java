package cn.lp.designpattern23.decoratormode;

public class FriedNoodles extends FastFood {
    public FriedNoodles() {
        super(12, "炒面");
    }

    @Override
    public float cost() {
        return getPrice();
    }
}
