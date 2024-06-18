package cn.lp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp
 * @Author: lp
 * @CreateTime: 2024-04-19  18:04
 * @Description: TODO
 * @Version: 1.0
 */
public class CopilotTest {
    public static void main(String[] args) {
        //创建一个集合
        List<Integer> list = new ArrayList<>();
        //添加元素
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        //调用过滤方法
        filter(list, 3);
    }
    //创建一个对Integer集合过滤的方法，传递进去一个集合和一个数字，根据这个数字过滤小于这个数字的集合，使用stream优化，以后都默认用stream遍历集合
    public static void filter(List<Integer> list, int num) {
        list.stream().filter(i -> i < num).forEach(System.out::println);
    }
//因为subList方法是在原集合上的一个视图，所以在原集合上进行增删操作，会导致subList的结果发生变化，所以在对原集合进行增删操作时，会抛出异常
    @Test
    public void testListSubList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        List<Integer> subList = list.subList(0, 2);
        System.out.println(subList);
        list.add(5);
        System.out.println(subList);
    }





}
