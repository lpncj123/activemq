package cn.lp.designpattern23.statusmode;

/**
 * 在接口中直接定义常量时，默认情况下它们都是静态常量，即公共的、静态的和不可变的。因此，int OPENING_STATE = 1;在接口中定义的常量是静态常量。
 * 在Java中，所有在接口中定义的变量都被认为是静态常量，即使没有显式地使用public static final修饰符。因此，接口中的常量都是公共的（public），静态的（static）和不可变的（final），它们的值不能被修改，因为它们被认为是常量，而不是变量。
 * 因此，int OPENING_STATE = 1;可以在接口中用来定义一个静态常量。但是，最好使用public static final修饰符来定义接口中的常量，以确保它们符合Java编码标准。
 */
public interface ILift {
    //电梯的4个状态
    //开门状态
    int OPENING_STATE = 1;
    //关门状态
    int CLOSING_STATE = 2;
    //运行状态
    int RUNNING_STATE = 3;
    //停止状态
    int STOPPING_STATE = 4;

    //设置电梯的状态
    void setState(int state);

    //电梯的动作
    void open();

    void close();

    void run();

    void stop();
}
