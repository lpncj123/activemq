package cn.lp.filter;

import cn.lp.model.User;
import cn.lp.model.vo.UserVO;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.pattern.filter.Filter;
import com.alibaba.cola.pattern.filter.FilterInvoker;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class UserVerifyFilter implements Filter<Map> {
    @Override
    public void doFilter(Map map, FilterInvoker filterInvoker) {
        Response response = (Response) map.get(Response.class.getSimpleName());
        User user = (User) map.get(User.class.getSimpleName());
        try{
            Preconditions.checkArgument(!Strings.isNullOrEmpty(user.getUserName()),"用户名不能为空");
            Preconditions.checkArgument(!Strings.isNullOrEmpty(user.getUserTelephone()),"电话号不能为空");
        }catch (IllegalArgumentException e){
            response.setErrCode("9999");
            response.setErrMessage("校验错误-"+e.getMessage());
            return;
        }catch (Exception e){
            response.setErrCode("666");
            response.setErrMessage("校验错误666");
            return;
        }
        filterInvoker.invoke(map);


    }
}
