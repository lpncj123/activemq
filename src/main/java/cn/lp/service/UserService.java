package cn.lp.service;


import cn.lp.model.User;
import cn.lp.model.vo.UserVO;
import cn.lp.utils.PageResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;

public interface UserService {
    Response getUserDataList(User user);

    PageResponse<User> getUserAllData(UserVO user);

    PageResponse<User> getUserAllData1();

    SingleResponse<User> selectAllUser(User user);

    Response deleteUser(Integer id);


    PageResponse<User> getUserAndClass(UserVO user);


    Response verification(UserVO user);

    Response verificationAnno(UserVO user);

    void insertUser(User user);
    void insertUser1(UserVO user);

    void insertUserV2(User user);
}
