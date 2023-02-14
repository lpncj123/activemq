package cn.lp.controller;

import cn.lp.model.User;
import cn.lp.model.vo.UserVO;
import cn.lp.service.UserService;
import cn.lp.tools.PageResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("userController")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/test/verify",method = RequestMethod.POST)
    public Response getUserData(@RequestBody User user){
        Response userDataList = userService.getUserDataList(user);
        return userDataList;
    }
    @RequestMapping(value = "/test/verify1",method = RequestMethod.POST)
    public PageResponse<User> getUserData1(@RequestBody UserVO user){
        log.info("传入参数:{}", JSON.toJSONString(user));
        PageResponse<User> userAllData = userService.getUserAllData(user);
        return userAllData;
    }

    @RequestMapping(value = "/test/string",method = RequestMethod.GET)
    public String getStringJson(@RequestParam String jsonString){
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



}
