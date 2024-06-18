package cn.lp.springeventexample;

import org.springframework.context.ApplicationEvent;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.springeventexample
 * @Author: lp
 * @CreateTime: 2024-04-18  16:45
 * @Description: TODO 创建事件
 * @Version: 1.0
 */
public class TestEvent extends ApplicationEvent {
    private String message;

    public TestEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public TestEvent(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
