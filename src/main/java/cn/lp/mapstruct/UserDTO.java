package cn.lp.mapstruct;

import lombok.Data;

@Data
public class UserDTO {
    private Integer userId;
    private String userName;
    private String userTelephone;
    private Integer userAge;
}
