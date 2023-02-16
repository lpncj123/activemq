package cn.lp.designpattern23.SingletonPattern;

/**
 * @author lp
 * 属于饿汉式
 */

public enum SingletonEnum {
    INSTANCE;
    public void doSomething() {
        // 单例实例的操作
    }
}
