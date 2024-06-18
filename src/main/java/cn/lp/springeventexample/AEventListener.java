package cn.lp.springeventexample;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.springeventexample
 * @Author: lp
 * @CreateTime: 2024-04-18  16:51
 * @Description: TODO 创建监听者
 * @Version: 1.0
 */
@Log4j2
@Component
public class AEventListener{
    @Async
    @EventListener(TestEvent.class)
    public void listener(TestEvent event) throws InterruptedException {
        Thread.sleep(2000);
        log.info("监听到数据：{}", event.getMessage());
    }

}
