package cn.lp.statemachine.service;

import cn.lp.statemachine.dto.StatementContext;
import com.alibaba.cola.statemachine.Condition;

public interface TestService {
    Condition<StatementContext> loanChannelOrderChangeCondition();
}
