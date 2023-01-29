package cn.lp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author lp
 */
@Document(collection = "user")//对应表名
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    public User(String userName, String userTelephone, Integer userAge) {
        this.userName = userName;
        this.userTelephone = userTelephone;
        this.userAge = userAge;
    }




    @Id
    private Integer userId;
    @Field("userName")//对应列名
    private String userName;
    private String userTelephone;
    private Integer userAge;
}
