package cn.lp.designpattern23.proxypattern.staticproxy;

import cn.lp.designpattern23.proxypattern.dynamicproxyjdk.SellTickets;

public class TrainStation implements SellTickets {
    @Override
    public void sell() {
        System.out.println("火车站卖票");
    }
}
