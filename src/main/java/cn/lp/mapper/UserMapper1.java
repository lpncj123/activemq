package cn.lp.mapper;


import cn.lp.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
  User selectAllUser(@Param("user") User user);


  /**
   * 删除用户
   * @param id 用户id
   * @return int
   */
  @Delete("delete from user where user_id = #{id}")
  int deleteUser(Integer id);
}
