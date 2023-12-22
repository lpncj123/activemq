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
     * 如果状态是CHANNEL_ORDER_PROCESSING，匹配到当前状态机，然后执行when里面的方法，如果返回true，状态返回成功，状态转换成功并且调用perform里面的方法
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
