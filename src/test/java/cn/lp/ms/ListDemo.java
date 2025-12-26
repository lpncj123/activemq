package cn.lp.ms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.ms
 * @Author: lp
 * @CreateTime: 2025-12-22  15:54
 * @Description: TODO
 * @Version: 1.0
 */
public class ListDemo {
    public static void main(String[] args) {
        int arr [] = {1,2,3,4,5,6,7,8,9};
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        Collections.sort( list,((o1, o2) -> o1 - o2));
        List<Integer> collect = list.stream().sorted((o1, o2) -> o2 - o1).collect(Collectors.toList());
        System.out.println(list);
        list.removeIf(item -> item % 2 == 0);

        List<String> lists = Arrays.asList("1","2","3","4","5");
        Stream<String> stream = lists.stream();
        Stream<String> stringStream = lists.parallelStream();

    }
}
