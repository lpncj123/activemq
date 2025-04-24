package cn.lp;

import cn.lp.springeventexample.my.UserPublishEvent;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp
 * @Author: lp
 * @CreateTime: 2024-05-23  15:42
 * @Description: TODO
 * @Version: 1.0
 */
public class SpringEventTest extends TestJunit{
    @Autowired
    private UserPublishEvent userPublishEvent;

    @Test
    public void test()
    {
        userPublishEvent.publish(22222,"lp","1221111111",13);
    }
}
