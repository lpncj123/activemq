package cn.lp.statemachine.dto;

import lombok.Data;

@Data
public class StatementContext {
    /**
     * 返回码
     */
    private String errCode;

    /**
     * 返回消息
     */
    private String errMessage;

    /**
     * status
     */
    private String status;

    /***
     * 设置渠道订单状态
     */
    private String LoanChannelOrderStatus;
}
