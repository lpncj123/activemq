package cn.lp.mapper;


import cn.lp.mapstruct.UserDTO;
import cn.lp.model.User;
import cn.lp.model.vo.UserVO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.provider.SpecialProvider;

import java.util.List;

//public interface UserMapper extends Mapper<User> {
public interface UserMapper extends Mapper<User>, MySqlMapper<User> {
  @Select("select * from user where user_age = #{user.userAge}")
  @Results(id = "user_id",value = {
    @Result(column="user_id",property="userId",jdbcType= JdbcType.INTEGER),
    @Result(column="user_name",property="userName",jdbcType=JdbcType.VARCHAR )
  })
  User selectAllUser(@Param("user") User user);

  List<User> select(UserVO user);

  @Options(useGeneratedKeys = true, keyProperty = "userId")
  @InsertProvider(
      type = SpecialProvider.class,
      method = "dynamicSQL"
  )
  @Override
  int insertList(List<? extends User> list);
}
