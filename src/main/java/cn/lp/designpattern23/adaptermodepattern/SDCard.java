package cn.lp.designpattern23.adaptermodepattern;

public interface SDCard {
    //读取SD卡方法
    String readSD();
    //写入SD卡功能
    void writeSD(String msg);
}
