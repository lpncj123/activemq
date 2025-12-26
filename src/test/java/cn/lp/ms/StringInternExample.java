package cn.lp.ms;

import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.ms
 * @Author: lp
 * @CreateTime: 2025-12-18  15:16
 * @Description: TODO
 * @Version: 1.0
 */
public class StringInternExample {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "Li hua";
//        反编译之后不是已经确定的字面值，所以不会被intern
//        String s3 = (new StringBuilder().append(s1).append(s2)).toString();
        String s3 = s1 + s2;
        String s4 = "helloLi hua";

        System.out.println(s3 == s4);
    }
}
