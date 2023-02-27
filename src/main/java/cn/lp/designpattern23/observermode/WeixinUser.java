package cn.lp.designpattern23.observermode;

public class WeixinUser implements Observer{
    // 微信用户名
    private String name;

    public WeixinUser(String name) {
        this.name = name;
    }
    @Override
    public void update(String message) {
        System.out.println(name + "-" + message);
    }
}
