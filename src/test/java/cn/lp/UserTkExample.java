package cn.lp;

import cn.lp.mapper.UserMapper;
import cn.lp.mapstruct.UserDTO;
import cn.lp.mapstruct.UserMapperMapStruct;
import cn.lp.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserTkExample extends TestJunit {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectUser() {

        Example example = new Example(User.class);
        //条件查询  select * from user where () or ()
        /*
       example.createCriteria().andEqualTo("userName","李四").andEqualTo("userAge",12);
        example.or(example.createCriteria().andEqualTo("userName","王五").andEqualTo("userAge",14));
        */
        //andBetween 对于数字两边都包括 对于日期只包括左边日期 不包括右边日期
//        example.createCriteria().andBetween("userAge",12,13);

        //in方法，传入集合
//        example.createCriteria().andIn("userAge", Lists.newArrayList(12));

        //排序的两种方式：第一种使用属性名 第二种使用数据库列名
//        example.orderBy("userTelephone").desc().orderBy("userAge").desc();
//        example.setOrderByClause("user_telephone DESC,user_age DESC");


//        SELECT user_id,user_name,user_telephone,user_age FROM user WHERE ( user_age = ? ) and ( user_name = ? or user_name = ? )

//        Example.Criteria a = example.createCriteria();
//        a.andEqualTo("userAge",14);
//        Example.Criteria b= example.createCriteria();
//        b.orEqualTo("userName","李四");
//        b.orEqualTo("userName","王五");
//        example.and(b);

//        example.createCriteria().andEqualTo("userAge",14);
//        example.and(example.createCriteria().andEqualTo("userName","李四").orEqualTo("userName","王五"));
        example.createCriteria().andLessThan("userAge",67);
        example.and(example.createCriteria().andLike("userName","王%"));

        List<User> userList = userMapper.selectByExample(example);
        List<UserDTO> list = new ArrayList<>();
        List<UserDTO> userDTOList = userList.stream().map(t -> {
//            UserDTO convert = UserMapperMapStruct.INSTANCE.convert(t);
            UserDTO convert = UserMapperMapStruct.INSTANCE.convert(t);
            return convert;
        }).collect(Collectors.toList());
        System.out.println(userDTOList);
    }

}
