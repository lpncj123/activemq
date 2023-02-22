package cn.lp.designpattern23.decoratormode;

public class Egg extends Garnish{
    public Egg(FastFood fastFood) {
        super(fastFood,1,"鸡蛋");
    }
    @Override
    public float cost() {
        return getPrice() + getFastFood().getPrice();
    }

    @Override
    public String getDesc() {
        return super.getDesc() + getFastFood().getDesc();
    }
}
