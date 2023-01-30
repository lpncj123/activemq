package cn.lp.statemachine.service.impl;

import cn.lp.statemachine.dto.StatementContext;
import cn.lp.statemachine.service.TestService;
import com.alibaba.cola.statemachine.Condition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestServiceImpl implements TestService {
    @Override
    public Condition<StatementContext> loanChannelOrderChangeCondition() {
        return (ctx)-> {
            ctx.setErrMessage("dsadsadsadsdqwqe");
            ctx.setStatus("dsadsad");
            log.info("条件执行成功");
            return  true;
        };
    }
}
