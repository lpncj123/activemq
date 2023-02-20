package cn.lp.designpattern23.proxypattern.staticproxy;

public class Client {
    public static void main(String[] args) {
        ProxyPoint pp = new ProxyPoint();
        pp.sell();
    }
}
