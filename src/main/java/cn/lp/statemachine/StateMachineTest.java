package cn.lp.statemachine;

import cn.lp.statemachine.dto.StatementContext;
import cn.lp.statemachine.enums.EventsEnum;
import cn.lp.statemachine.enums.StatesEnum;
import cn.lp.statemachine.service.TestActionService;
import cn.lp.statemachine.service.TestService;
import com.alibaba.cola.statemachine.builder.StateMachineBuilder;
import com.alibaba.cola.statemachine.builder.StateMachineBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class StateMachineTest {
    static String MACHINE_ID = "TestStateMachine";
    @Autowired
    private TestService testService;
    @Autowired
    private TestActionService testActionService;

    /***
     * 创建订单服务
     */
    @PostConstruct
    public void creteTestStateMachine() throws Exception {
        StateMachineBuilder<StatesEnum, EventsEnum, StatementContext> builder = StateMachineBuilderFactory.create();
        builder.externalTransition()
            .from(StatesEnum.CHANNEL_ORDER_PROCESSING)
            .to(StatesEnum.CHANNEL_ORDER_QUERY_SUCCESS)
            .on(EventsEnum.UPDATE_CHANNEL_ORDER_EVENT)
            .when(testService.loanChannelOrderChangeCondition())
            .perform(testActionService.updateChannelOrderAction());
        builder.build(MACHINE_ID);
    }
}
