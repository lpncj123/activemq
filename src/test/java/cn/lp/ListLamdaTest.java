package cn.lp;

import cn.lp.model.User;

import java.util.*;
import java.util.stream.Collectors;

public class ListLamdaTest {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User(1,"李四","15022222222",12));
        list.add(new User(2,"李八","15022222123",9870));
        list.add(new User(2,"李五","15022222221",213212));
        list.add(new User(2,null,"15022227890",797856));
        list.add(new User(3,"赵六","15022222321",4543));
        //拿出集合字段
        List<Integer> integerList = list.stream().map(User::getUserId).collect(Collectors.toList());
        List<Integer> collect = list.stream().filter(e -> e.getUserAge() > 12).map(User::getUserId).distinct().collect(Collectors.toList());
        List<User> collect1 = list.stream().sorted(Comparator.comparing(User::getUserAge).reversed()).collect(Collectors.toList());
        //当集合中有主键重复时，选择最后面还是最前面的数据当做value
        Map<Integer, User> map = list.stream().collect(Collectors.toMap(User::getUserId,e->e,(key1,key2)->{
            if(Objects.equals(key1.getUserId(), key2.getUserId())){
                return key2;
            }
            return null;
        }));
        //最后一个参数是为了操作value的值
        Map<Integer, List<String>> map1 = list.stream().collect(Collectors.toMap(User::getUserId, e-> {
            List<String> getNameList = new ArrayList<>();
            getNameList.add(e.getUserName());
            return getNameList;
        },(List<String> value1, List<String> value2)->{
            value1.addAll(value2);
            return  value1;
        }));
    }
}
