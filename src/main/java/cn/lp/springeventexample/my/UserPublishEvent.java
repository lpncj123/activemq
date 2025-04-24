package cn.lp.springeventexample.my;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.springeventexample.my
 * @Author: lp
 * @CreateTime: 2024-05-23  15:20
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class UserPublishEvent {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    public void publish(Integer userId,String userName, String userTelephone, Integer userAge)
    {
        applicationEventPublisher.publishEvent(new UserEvent(this,userId,userName,userTelephone,userAge));
    }
}
