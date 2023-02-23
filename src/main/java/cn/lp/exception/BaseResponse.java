package cn.lp.exception;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.utils
 * @Author: lp
 * @CreateTime: 2023-02-23  14:05
 * @Description: TODO
 * @Version: 1.0
 */
@ApiModel(
    value = "基础响应对象",
    description = "基础接口响应对象"
)
@Data
public class BaseResponse {
    @ApiModelProperty(
        value = "响应描述",
        name = "message",
        example = "OK"
    )
    private String message;
    @ApiModelProperty(
        value = "响应码",
        name = "code",
        example = "00000000"
    )
    private String code;
    @ApiModelProperty(
        value = "响应状态",
        name = "status",
        example = "1"
    )
    private String status;

    public BaseResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public BaseResponse(String status, String message, String code) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

    public BaseResponse() {
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("BaseResponse{");
        sb.append("message='").append(this.message).append('\'');
        sb.append(", code='").append(this.code).append('\'');
        sb.append(", status='").append(this.status).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
