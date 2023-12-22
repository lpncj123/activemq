package cn.lp.filter;

import cn.lp.enums.BaseRespCodeEnum;
import cn.lp.mapper.UserMapper;
import cn.lp.model.User;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.pattern.filter.Filter;
import com.alibaba.cola.pattern.filter.FilterInvoker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Map;

@Component
public class UserAddFilter implements Filter<Map> {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public void doFilter(Map map, FilterInvoker filterInvoker) {
        User user = (User) map.get(User.class.getSimpleName());
        Response response = (Response) map.get(Response.class.getSimpleName());
//      没有返回值的局部手动事务回滚
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            public void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    userMapper.insert(user);
                    int i = 1 / 0;
                    response.setSuccess(true);
                    response.setErrCode(BaseRespCodeEnum.SUCCESS.getCode());
                    response.setErrMessage(BaseRespCodeEnum.SUCCESS.getMessage());
                } catch (Exception e) {
                    response.setSuccess(false);
                    response.setErrCode(BaseRespCodeEnum.FAIL.getCode());
                    response.setErrMessage(BaseRespCodeEnum.FAIL.getMessage());
                    transactionStatus.setRollbackOnly();
                }
            }
        });
        //有返回值的局部手动事务回滚
//        transactionTemplate.execute(new TransactionCallback<Object>() {
//
//            @Override
//            public Object doInTransaction(TransactionStatus transactionStatus) {
//                transactionStatus.setRollbackOnly();
//                return "1111";
//            }
//        });


    }
}
