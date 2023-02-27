package cn.lp.mapper;


import cn.lp.model.User;
import org.apache.ibatis.annotations.*;

public interface UserMapper1{
  /**
   * @param user
   * @return
   */
  @Select("<script>select * from user where user_age = #{user.userAge}" +
      "<if test='user.userId!=null and user.userId!=\"\"'>" +
      "and user_id=#{user.userId}" +
      "</if>" +
      "</script>")
//  @Results({
//      @Result(property = "userId", column = "user_id", id = true),
//      @Result(property = "userName", column = "user_name"),
//      @Result(property = "userTelephone", column = "user_telephone"),
//      @Result(property = "userAge", column = "user_age")
//  })
  User selectAllUser(@Param("user") User user);


  /**
   * 删除用户
   * @param id 用户id
   * @return int
   */
  @Delete("delete from user where user_id = #{id}")
  int deleteUser(Integer id);
}
