package cn.lp.bean;

import javax.persistence.*;

@Table(name = "`user`")
public class User {
    /**
     * 用户id
     */
    @Id
    @Column(name = "`user_id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    /**
     * 用户姓名
     */
    @Column(name = "`user_name`")
    private String userName;

    /**
     * 用户手机号
     */
    @Column(name = "`user_telephone`")
    private String userTelephone;

    @Column(name = "`user_age`")
    private Integer userAge;

    @Column(name = "`content`")
    private String content;

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取用户姓名
     *
     * @return user_name - 用户姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户姓名
     *
     * @param userName 用户姓名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取用户手机号
     *
     * @return user_telephone - 用户手机号
     */
    public String getUserTelephone() {
        return userTelephone;
    }

    /**
     * 设置用户手机号
     *
     * @param userTelephone 用户手机号
     */
    public void setUserTelephone(String userTelephone) {
        this.userTelephone = userTelephone;
    }

    /**
     * @return user_age
     */
    public Integer getUserAge() {
        return userAge;
    }

    /**
     * @param userAge
     */
    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }
}