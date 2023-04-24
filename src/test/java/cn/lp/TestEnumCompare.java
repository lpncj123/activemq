package cn.lp;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp
 * @Author: lp
 * @CreateTime: 2023-04-03  16:12
 * @Description: TODO
 * @Version: 1.0
 */
public class TestEnumCompare {
    public static void main(String[] args) throws Exception {
        // 获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统类加载器：" + systemClassLoader);
        // 获取系统类加载器的父类加载器，即扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println("扩展类加载器：" + extClassLoader);
        // 获取扩展类加载器的父类加载器，即启动类加载器
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println("启动类加载器：" + bootstrapClassLoader);
        List<String> stringList = new ArrayList<>();
        stringList.add("hello");
        stringList.add("world");

        Field field = stringList.getClass().getDeclaredField("elementData");
        field.setAccessible(true);
        Object[] elementData = (Object[]) field.get(stringList);
        elementData[0] = 123;
        for (String s : stringList) {
            System.out.println(s);
        }
    }
}
