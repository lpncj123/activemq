package cn.lp.transction;

import cn.lp.TestJunit;
import cn.lp.model.User;
import cn.lp.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.transction
 * @Author: lp
 * @CreateTime: 2024-03-22  16:43
 * @Description: TODO
 * @Version: 1.0
 */
public class TransctionQianTaoTest extends TestJunit {
    @Autowired
    private UserService userService;

    @Test
    public void insertUser() {
        User user = new User();
        user.setUserName("Ncj11");
        user.setUserTelephone("15048293199");
        user.setUserAge(925);
        userService.insertUser(user);
//        jisuan();
    }



}
