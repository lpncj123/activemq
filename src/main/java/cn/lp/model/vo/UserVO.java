package cn.lp.model.vo;

import com.alibaba.cola.dto.PageQueryDTO;
import lombok.Data;

import javax.validation.constraints.NotBlank;


/**
 * @author lp
 */
@Data
public class UserVO extends PageQueryDTO {

    private Integer userId;
    @NotBlank(message = "姓名不能为空")
    private String userName;
    private String userTelephone;
    private Integer userAge;
}
