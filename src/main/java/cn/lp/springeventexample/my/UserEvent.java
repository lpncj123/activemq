package cn.lp.springeventexample.my;

import org.springframework.context.ApplicationEvent;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.springeventexample.my
 * @Author: lp
 * @CreateTime: 2024-05-23  15:15
 * @Description: TODO
 * @Version: 1.0
 */
    public class UserEvent extends ApplicationEvent {
    public UserEvent(Object source, Integer userId, String userName, String userTelephone, Integer userAge) {
        super(source);
        this.userId = userId;
        this.userName = userName;
        this.userTelephone = userTelephone;
        this.userAge = userAge;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTelephone() {
        return userTelephone;
    }

    public void setUserTelephone(String userTelephone) {
        this.userTelephone = userTelephone;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    private Integer userId;

        private String userName;

        private String userTelephone;
        private Integer userAge;


    }
