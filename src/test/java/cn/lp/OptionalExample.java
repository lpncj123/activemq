package cn.lp;

import java.util.Optional;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: PACKAGE_NAME
 * @Author: lp
 * @CreateTime: 2025-05-19  14:01
 * @Description: TODO
 * @Version: 1.0
 */
public class OptionalExample {
    public static void main(String[] args) {
//        ofNullable创建一个可能为空的Optional对象
        Optional.ofNullable("hello")
//            Java9引入，如果值存在，则执行第一个方法，否则执行第二个方法。如果是普通的ifPresent则是值存在就执行后面方法。
            .ifPresent(
                value -> System.out.println("Value is present: " + value)
//                () -> System.out.println("Value is absent")
            );

        Optional<String> opt = Optional.of("Java");
//        map方法将Optional中的值映射到另一个值
        Optional<Integer> length = opt.map(String::length);
        length.ifPresent(l -> System.out.println("Length: " + l));

        Integer i = length.get();
    }
}
