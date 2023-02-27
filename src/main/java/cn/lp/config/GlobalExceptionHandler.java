package cn.lp.config;

import cn.lp.enums.BaseRespCodeEnum;
import cn.lp.enums.BaseRespStatusEnum;
import cn.lp.exception.BaseException;
import cn.lp.exception.BaseResponse;
import com.alibaba.cola.dto.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.controller
 * @Author: lp
 * @CreateTime: 2023-02-22  17:34
 * @Description: TODO
 * @Version: 1.0
 */
/**
 @ControllerAdvice 是 Spring MVC 提供的一种处理异常的方式，它可以将所有 @RequestMapping 的方法的异常集中到一个地方进行处理，以减少重复代码的编写。
 在 @ControllerAdvice 中，有三个参数可以使用，分别是 annotations、basePackages 和 assignableTypes，它们的作用如下：
 annotations：指定注解，表示只处理带有该注解的 Controller 类中的异常；
 basePackages：指定包名，表示只处理指定包下的 Controller 类中的异常；
 assignableTypes：指定类型，表示只处理指定类型的 Controller 类中的异常。
 这三个参数可以根据具体的需求进行组合使用。如果不指定参数，则默认处理所有的 Controller 类中的异常。
 **/
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({BaseException.class})
    public BaseResponse baseExceptionHandler(HttpServletResponse response, BaseException ex) {
        LOGGER.error(ex.getMessage(), ex);
        response.setStatus(500);
        return new BaseResponse(BaseRespStatusEnum.FAIL.getCode(), ex.getMessage(), BaseRespCodeEnum.SYSTEM_ERROR.getCode());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<String> errorMessages = bindingResult.getAllErrors()
            .stream()
            .map(DefaultMessageSourceResolvable::getDefaultMessage)
            .collect(Collectors.toList());
        Response.buildFailure("","").setStatus("");
        return Response.buildFailure("00000001",String.join(",", errorMessages));
    }

//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public Response handleException(Exception ex) {
//        // 处理其他异常
//        return Response.buildFailure("999999","系统错误-"+ex.getMessage());
//    }
}