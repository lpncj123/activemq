package cn.lp.ms;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.ms
 * @Author: lp
 * @CreateTime: 2025-12-22  15:28
 * @Description: TODO
 * @Version: 1.0
 */
public class StaticDemo {
    private static String name;
    private static Integer age;
    {
        System.out.println("初始化");
        name="Li hua";
        age=12;
    }

    public static void main(String[] args) {
        StaticDemo staticDemo = new StaticDemo();
        System.out.println("name:"+name+",age:"+age);
    }
}