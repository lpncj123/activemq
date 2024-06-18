package cn.lp.springeventexample.my;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.springeventexample.my
 * @Author: lp
 * @CreateTime: 2024-05-23  15:40
 * @Description: TODO
 * @Version: 1.0
 */
@Component
public class UserListener {
    @TransactionalEventListener
    public void listener(UserEvent event)
    {
        System.out.println("接收到事件："+event.getUserId());
    }
}
