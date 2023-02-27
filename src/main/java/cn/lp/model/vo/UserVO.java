package cn.lp.model.vo;

import com.alibaba.cola.dto.PageQueryDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;


/**
 * @author lp
 */
@Data
@ApiModel(value = "用户信息", description = "id，name，telephone，age")
public class UserVO extends PageQueryDTO {
    @ApiModelProperty(value = "用户Id", example = "1")
    private Integer userId;
    @NotBlank(message = "姓名不能为空")
    @ApiModelProperty(value = "用户姓名", example = "lp")
    private String userName;
    @ApiModelProperty(value = "用户电话", example = "1221111111")
    private String userTelephone;
    @ApiModelProperty(value = "用户年龄", example = "13")
    private Integer userAge;
}
