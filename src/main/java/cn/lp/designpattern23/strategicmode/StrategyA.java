package cn.lp.designpattern23.strategicmode;

public class StrategyA  implements Strategy{
    @Override
    public void show() {
        System.out.println("买一送一");
    }
}
