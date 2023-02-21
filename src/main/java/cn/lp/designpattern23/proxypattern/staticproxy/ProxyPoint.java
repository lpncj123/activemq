package cn.lp.designpattern23.proxypattern.staticproxy;

import cn.lp.designpattern23.proxypattern.dynamicproxy.SellTickets;

public class ProxyPoint implements SellTickets {
    private TrainStation station = new TrainStation();

    @Override
    public void sell() {
        System.out.println("代理点收取一些服务费用");
        station.sell();
    }
}
