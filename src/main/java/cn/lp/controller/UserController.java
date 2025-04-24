package cn.lp.controller;

import cn.lp.model.User;
import cn.lp.model.vo.UserVO;
import cn.lp.service.UserService;
import cn.lp.springeventexample.PublishEvent;
import cn.lp.springeventexample.my.UserPublishEvent;
import cn.lp.utils.PageResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("userController")
@Slf4j
@Api(tags = "自己测试查询用户")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PublishEvent publishEvent;
    @Autowired
    private UserPublishEvent userPublishEvent;
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

    @ApiOperation(value = "插入用户", notes = "校验事务",tags = "参数测试")
    @RequestMapping(value = "/test/insertUser",method = RequestMethod.POST)
    public void insertUser(@RequestBody User user){
        userService.insertUser(user);
    }

    @RequestMapping("pub")
    public void pub() {
        for (int i = 0; i < 5; i++) {
            publishEvent.publish("你若为我繁华，你好呀：" + (i + 1));
        }
    }
    @RequestMapping("pub1")
    @Transactional
    public void pub1() {
        userPublishEvent.publish(222, "lp", "123456", 18);
        int i = 1 / 0;
    }

}
