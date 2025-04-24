package cn.lp.springeventexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.springeventexample
 * @Author: lp
 * @CreateTime: 2024-04-18  16:55
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class PublishEvent {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publish(String message) {
        applicationEventPublisher.publishEvent(new TestEvent(message));
    }

}
