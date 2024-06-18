package cn.lp.list;

import java.util.*;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp
 * @Author: lp
 * @CreateTime: 2024-05-09  17:01
 * @Description: TODO
 * @Version: 1.0
 */
public class ListBlAndUpdate {
    public static void main(String[] args) {
        blList4();
    }
    public static void blList(){
        // 写一个ArrayList集合，里面有5个数字
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)%2==0){
                list.remove(i);
                i--;
            }
        }
        list.forEach(System.out::println);

    }
    //使用迭代器遍历list，移除元素。避免了直接修改正在遍历的集合
    public static void blList2(){
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        list.removeIf(i -> i % 2 == 0);
        list.forEach(System.out::println);
    }

    //使用stream遍历list，过滤掉不需要的元素
    public static void blList3(){
        new HashMap<>();
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        list.stream().filter(i -> i % 2 == 0).forEach(System.out::println);
    }

    //创建学生集合，过滤掉年龄小于18的学生并倒序排序
    public static void blList4(){
        List<Student> list = new ArrayList<>(Arrays.asList(new Student("张三", 18), new Student("李四", 20), new Student("王五", 16)));
        list.stream().filter(s -> s.getAge() >= 18).sorted(Comparator.comparingInt(Student::getAge).reversed()).forEach(System.out::println);
    }
}
