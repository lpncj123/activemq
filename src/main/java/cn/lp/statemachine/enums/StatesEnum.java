package cn.lp.statemachine.enums;

import lombok.Getter;

@Getter
public enum StatesEnum {
    /**
     * 渠道订单处理中
     */
    CHANNEL_ORDER_PROCESSING("channelOrderProcessing"),
    /**
     * 更新渠道订单终态
     */
    CHANNEL_ORDER_QUERY_SUCCESS("updateOrderQuerySuccess"),
    /**
     * 根据异步通知更新渠道订单为终态
     */
    CHANNEL_NOTIFY_ORDER_SUCCESS("channelNotifyOrderSuccess"),
    /**
     * 更新账务系统
     */
    CALL_ACCOUNT_SUCCESS("callAccountSuccess"),
    /**
     * 借款订单更新为终态
     */
    LOAN_SUCCESS("loanSuccess"),

    /**
     * 更新还款订单的状态
     */
    LOAN_REPAYMENT_SUCCESS("loanRepaymentSuccess"),
    /**
     * 车贷订单更新为终态
     */
    CAR_LOAN_ORDER_SUCCESS("carLoanOrderSuccess"),
    /**
     * 异步通知状态
     */
    NOTIFY("notify");
    private   String name;

    private  StatesEnum (String name){
        this.name=name;
    }
    public  String getName(){
        return  this.name;
    }

}
