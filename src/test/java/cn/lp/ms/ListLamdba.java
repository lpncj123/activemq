package cn.lp.ms;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.ms
 * @Author: lp
 * @CreateTime: 2025-12-18  15:36
 * @Description: TODO
 * @Version: 1.0
 */
public class ListLamdba {
    public static void main(String[] args) {
        List<String> list = ImmutableList.of( "hello", "world", "java");
        list.stream().filter(s->s.contains("a")).forEach(System.out::println);

    }
}
