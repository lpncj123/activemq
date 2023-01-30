package cn.lp.statemachine.service;

import cn.lp.statemachine.dto.StatementContext;
import cn.lp.statemachine.enums.EventsEnum;
import cn.lp.statemachine.enums.StatesEnum;
import com.alibaba.cola.statemachine.Action;

public interface TestActionService {
    Action<StatesEnum, EventsEnum, StatementContext> updateChannelOrderAction();
}
