package cn.lp.controller;

import cn.lp.model.User;
import cn.lp.model.vo.UserVO;
import cn.lp.service.UserService;
import cn.lp.utils.PageResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("userController")
@Slf4j
@Api(tags = "自己测试查询用户")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/test/verify",method = RequestMethod.POST)
    public Response getUserData(@RequestBody User user){
        Response userDataList = userService.getUserDataList(user);
        return userDataList;
    }
    @ApiOperation(value = "查询用户", notes = "支持根据年龄和姓名查询",tags = "用户查询")
    @RequestMapping(value = "/test/verify1",method = RequestMethod.POST)
    public PageResponse<User> getUserData1(@RequestBody UserVO user){
        log.info("传入参数:{}", JSON.toJSONString(user));
        PageResponse<User> userAllData = userService.getUserAllData(user);
        return userAllData;
    }
    @ApiOperation(value = "测试查询字符串返回方法", notes = "传入字符串返回",tags = "测试方法")
    @RequestMapping(value = "/test/string",method = RequestMethod.GET)
    public String getStringJson( String jsonString){
        return jsonString;
    }

    @RequestMapping(value = "/test/allUser",method = RequestMethod.POST)
    public SingleResponse<User> selectAllUser(@RequestBody User user){
        return userService.selectAllUser(user);
    }
    @RequestMapping(value = "/test/deleteUser",method = RequestMethod.POST)
    public Response deleteUser(@RequestBody User user){
        return userService.deleteUser(user.getUserId());
    }
    @RequestMapping(value = "/test/getUserAndClass",method = RequestMethod.POST)
    public Response getUserAndClass(@RequestBody UserVO user){
        return userService.getUserAndClass(user);
    }

    @RequestMapping(value = "/test/verification",method = RequestMethod.POST)
    public Response verification(@RequestBody UserVO user){
        return userService.verification(user);
    }

    @ApiOperation(value = "校验参数", notes = "校验用户姓名是否为空",tags = "参数测试")
    @RequestMapping(value = "/test/verificationAnno",method = RequestMethod.POST)
    public Response verificationAnno(@Validated @RequestBody  UserVO user){
        return userService.verificationAnno(user);
    }



}
