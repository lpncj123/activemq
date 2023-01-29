package cn.lp;

import cn.lp.model.User;
import cn.lp.model.vo.UserVO;
import cn.lp.service.UserService;
import com.alibaba.cola.dto.Response;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class FilterTest extends TestJunit{
    @Autowired
    private UserService userService;
    @Test
    public void testFilter(){
        User user = new User();
        user.setUserName("李四");
        user.setUserTelephone("1321312");
        Response userDataList = userService.getUserDataList(user);
        System.out.println(userDataList);
    }
}
