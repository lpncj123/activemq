package cn.lp.service.impl;

import cn.lp.enums.BaseRespCodeEnum;
import cn.lp.filter.UserAddFilter;
import cn.lp.filter.UserVerifyFilter;
import cn.lp.mapper.UserMapper;
import cn.lp.mapper.UserMapper1;
import cn.lp.model.User;
import cn.lp.model.vo.UserVO;
import cn.lp.service.UserService;
import cn.lp.utils.PageResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.cola.pattern.filter.FilterChain;
import com.alibaba.cola.pattern.filter.FilterChainFactory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author lp
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserMapper1 userMapper1;

    @Override
    public Response getUserDataList(User user) {
        Class[] getUserData = {
            //验证参数是否为空
            UserVerifyFilter.class,
            UserAddFilter.class

        };
        //创建执行链
        FilterChain<Map> accountDataFilterChain = FilterChainFactory.buildFilterChain(getUserData);
        Response response = new Response();
        Map context = new HashMap();
        context.put(Response.class.getSimpleName(), response);
        context.put(User.class.getSimpleName(), user);
        accountDataFilterChain.doFilter(context);
        return response;
    }

    @Override
    public PageResponse<User> getUserAllData(UserVO user) {
        PageHelper.startPage(user.getCurrent(), user.getPageSize());
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        if (!Objects.isNull(user)) {
            if (!Strings.isNullOrEmpty(user.getUserName())) {
                criteria.andEqualTo("userName", user.getUserName());
            }
            if (!Strings.isNullOrEmpty(user.getUserTelephone())) {
                criteria.andEqualTo("userTelephone", user.getUserTelephone());
            }
        }
        List<User> userList = userMapper.selectByExample(example);
        log.info("放入前userList：{}", userList);
        PageInfo pageInfo = new PageInfo(userList);
        log.info("放入后userList：{}", userList);
        PageResponse pageResponse = new PageResponse();
        pageResponse.setTotal(Long.valueOf(pageInfo.getTotal()).intValue());
        pageResponse.setTotalPage((long) pageInfo.getPages());
        pageResponse.setPageSize((long) pageInfo.getPageSize());
        pageResponse.setCurrent(pageInfo.getPageNum());
        pageResponse.setSuccess(true);
        pageResponse.setData(userList);
        pageResponse.setErrCode(BaseRespCodeEnum.SUCCESS.getCode());
        pageResponse.setErrMessage(BaseRespCodeEnum.SUCCESS.getMessage());
        return pageResponse;
    }

    @Override
    public PageResponse<User> getUserAllData1() {
        List<User> userList = userMapper.selectAll();
        PageInfo pageInfo = new PageInfo(userList);
        PageResponse pageResponse = new PageResponse();
        pageResponse.setTotal(Long.valueOf(pageInfo.getTotal()).intValue());
        pageResponse.setTotalPage(Long.valueOf(pageInfo.getPages()));
        pageResponse.setPageSize(Long.valueOf(pageInfo.getPageSize()));
        pageResponse.setCurrent(pageInfo.getPageNum());
        pageResponse.setData(userList);
        pageResponse.setSuccess(true);
        pageResponse.setErrCode(BaseRespCodeEnum.SUCCESS.getCode());
        pageResponse.setErrMessage(BaseRespCodeEnum.SUCCESS.getMessage());
        return pageResponse;
    }

    @Override
    public SingleResponse selectAllUser(User user) {
        try {
            SingleResponse response = new SingleResponse();
            User user1 = userMapper1.selectAllUser(user);
            System.out.println(user1);
            response.setData(user1);
            response.setErrCode(BaseRespCodeEnum.SUCCESS.getCode());
            response.setSuccess(true);
            response.setErrMessage(BaseRespCodeEnum.SUCCESS.getMessage());
            return response;
        } catch (Exception e) {
            log.info("查询发生异常:{}", e);
        }
        return null;
    }

    @Override
    public Response deleteUser(Integer id) {
        Response response = new Response();
        int i = userMapper1.deleteUser(id);
        if (i > 0) {
            response.setSuccess(true);
            response.setErrCode(BaseRespCodeEnum.SUCCESS.getCode());
            response.setErrMessage(BaseRespCodeEnum.SUCCESS.getMessage());
        } else {
            response.setSuccess(false);
            response.setErrCode(BaseRespCodeEnum.FAIL.getCode());
            response.setErrMessage(BaseRespCodeEnum.FAIL.getMessage());
        }
        return response;
    }

    @Override
    public PageResponse<User> getUserAndClass(UserVO user) {
        System.out.println(user.getUserId());
//        Example example = new Example(User.class);
//        Example.Criteria criteria = example.createCriteria();
//        if(!Objects.isNull(user)){
//            if(!Strings.isNullOrEmpty(String.valueOf(user.getUserId()))){
//                criteria.andEqualTo("userId",user.getUserId());
//            }
//            if(!Strings.isNullOrEmpty(String.valueOf(user.getUserName()))){
//                criteria.andLike("userName",user.getUserName()+"%");
//
//            }
//        }
        /**
         * tk-myabtis查询直接传对象就可以，没必要判空值
         */
//        criteria.andEqualTo(user);
//        List<User> users = userMapper.select(user);
//        System.out.println(users);
//        List<User> userList = userMapper.selectByExample(example);
//        User user1 = UserMapperMapStruct.INSTANCE.convertUserVo(user);
//        int i = userMapper.updateByPrimaryKey(user1);
//        System.out.println(i);
//        System.out.println(userList);
//        User user1 = UserMapperMapStruct.INSTANCE.convertUserVo(user);
//        int i = userMapper.insertSelective(user1);
//        System.out.println(i);


//        User zuser = new User("赵文龙", "15011111111", 12);
//        User luser = new User("刘备", "15011111112", 13);
//        List<User> list = Lists.newArrayList(zuser);
//        int i = userMapper.insertList(list);
//        System.out.println(i);
        Example example = new Example(User.class);
        example.createCriteria().andCondition("user_telephone='15011111111'");
        example.createCriteria().andEqualTo("userAge", 12);
        example.and(example.createCriteria().andEqualTo("userName", "赵文龙").orEqualTo("userName", "刘备"));
        example.setOrderByClause("user_id desc,user_telephone asc");
//        example.setDistinct(true);
        List<User> users = userMapper.selectByExample(example);
        System.out.println(users);

        return null;
    }

    @Override
    public Response verification(UserVO user) {
        try {
            Preconditions.checkNotNull(user.getUserAge(), "年龄不能为空");
            Preconditions.checkNotNull(user.getUserId(), "年龄不能为空");
        } catch (Exception e) {
            log.info("校验发生异常 :{}", e.getMessage());
            return Response.buildFailure("00000001", "错误");
        }
        return Response.buildFailure("00000000", "正确");
    }

    @Override
    public Response verificationAnno(UserVO user) {
        try {
            return Response.buildFailure("00000000", "正确");
        } catch (Exception e) {
            return Response.buildFailure("00000001", "错误");
        }

    }

    @Override
    public void insertUser(User user) {
        try {
            userMapper.insert(user);
            insertUserV2(user);
        } catch (Exception e) {
            log.info("error-->", e);
        }
    }

    @Override
    public void insertUser1(UserVO user) {
        User user1 = new User();
        BeanUtils.copyProperties(user, user1);
        userMapper.insert(user1);
    }

    @Override
    @Transactional( propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public void insertUserV2(User user) {

        userMapper.insert(user);
        int i = 1 / 0;


    }
}
