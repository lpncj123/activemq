package cn.lp.designpattern23.adaptermodepattern;

public interface TFCard {
    //读取TF卡方法
    String readTF();
    //写入TF卡功能
    void writeTF(String msg);
}
