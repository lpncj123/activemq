package cn.lp.designpattern23.proxypattern.cglibdynamicproxy;


public class TrainStation implements SellTickets {
    @Override
    public void sell() {
        System.out.println("火车站卖票");
    }
}
