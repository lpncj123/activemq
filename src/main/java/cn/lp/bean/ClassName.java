package cn.lp.bean;

import javax.persistence.*;

@Table(name = "`class`")
public class ClassName {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "`type`")
    private Byte type;

    @Column(name = "`class_name`")
    private String className;

    @Column(name = "`user_id`")
    private Integer userId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return type
     */
    public Byte getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * @return class_name
     */
    public String getClassName() {
        return className;
    }

    /**
     * @param className
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}