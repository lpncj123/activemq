package cn.lp;

import cn.lp.statemachine.dto.StatementContext;
import cn.lp.statemachine.enums.EventsEnum;
import cn.lp.statemachine.enums.StatesEnum;
import com.alibaba.cola.statemachine.StateMachine;
import com.alibaba.cola.statemachine.StateMachineFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
@Slf4j
public class StateMachineTest extends TestJunit{
    private static String MACHINE_ID = "TestStateMachine";
    @Test
    public void testStateMachine(){
        StateMachine<Object, Object, Object> stateMachine = StateMachineFactory.get(MACHINE_ID);
        StatementContext statementContext = new StatementContext();
        StatesEnum fireEvent = (StatesEnum) stateMachine.fireEvent(StatesEnum.CHANNEL_ORDER_PROCESSING, EventsEnum.UPDATE_CHANNEL_ORDER_EVENT, statementContext);
        log.info("渠道订单状态：{}", fireEvent);
    }
}
