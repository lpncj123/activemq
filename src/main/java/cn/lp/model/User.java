package cn.lp.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "用户信息（主）", description = "id，name，telephone，age")
public class User implements Serializable {

    public User(String userName, String userTelephone, Integer userAge) {
        this.userName = userName;
        this.userTelephone = userTelephone;
        this.userAge = userAge;
    }

    @Id
    @ApiModelProperty(value = "用户ID", example = "1")
    private Integer userId;
    @Field("userName")//对应列名
    @ApiModelProperty(value = "用户姓名", example = "lp")
    private String userName;
    @ApiModelProperty(value = "用户电话号", example = "1221111111")
    private String userTelephone;
    @ApiModelProperty(value = "用户年龄", example = "13")
    private Integer userAge;
}
