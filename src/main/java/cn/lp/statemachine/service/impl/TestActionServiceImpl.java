package cn.lp.statemachine.service.impl;

import cn.lp.statemachine.dto.StatementContext;
import cn.lp.statemachine.enums.EventsEnum;
import cn.lp.statemachine.enums.StatesEnum;
import cn.lp.statemachine.service.TestActionService;
import com.alibaba.cola.statemachine.Action;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TestActionServiceImpl implements TestActionService {
    @Override
    public Action<StatesEnum, EventsEnum, StatementContext> updateChannelOrderAction() {
        return (from, to, event, ctx)->{
            log.info("from:{}",from);
            log.info("to:{}",to);
            log.info("event:{}",event);
            log.info("读取到的信息：{}", JSON.toJSONString(ctx));
            log.info("更新数据库成功");
        };
    }
}
