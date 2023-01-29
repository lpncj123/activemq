package cn.lp.enums;

import cn.lp.tools.MessageUtils;
import com.alibaba.cola.domain.ApplicationContextHelper;


public enum BaseRespCodeEnum {
        SUCCESS("00000000", "Success", BaseRespStatusEnum.SUCCESS.getCode(), "base.success"),
        SUCCESS_NO_VALUE("00000001", "处理成功", BaseRespStatusEnum.SUCCESS.getCode(), "base.success.no.value"),
        FAIL("00000002", "Fail", BaseRespStatusEnum.FAIL.getCode(), "base.fail"),
        PENDING("00000003", "Pending", BaseRespStatusEnum.FAIL.getCode(), "base.pending"),
        SYSTEM_ERROR("99999999", "System error", BaseRespStatusEnum.FAIL.getCode(), "base.system.error"),
        DATABASE_EXCEPTION("99999998", "数据库异常", BaseRespStatusEnum.FAIL.getCode(), "base.database.error"),
        MULTI_QUERY_RESULT("99999997", "多个查询结果", BaseRespStatusEnum.FAIL.getCode(), "base.multiple.query.results"),
        INVOKE_EXCEPTION("99999996", "调用接口异常", BaseRespStatusEnum.FAIL.getCode(), "base.call.interface.exception"),
        FAIL_NO_VALUE("99999995", "未查询到结果", BaseRespStatusEnum.FAIL.getCode(), "base.no.results.found"),
        RECORD_EXIST("99999994", "记录已存在", BaseRespStatusEnum.FAIL.getCode(), "base.record.already.exists"),
        OSS_EXCEPTION("99999993", "oss服务异常", BaseRespStatusEnum.FAIL.getCode(), "base.oss.service.is.abnormal"),
        INVALID_PARAMETER("99999992", "无效参数", BaseRespStatusEnum.FAIL.getCode(), "base.invalid.parameter"),
        DUPLICATE_TRADE("99999991", "重复的请求", BaseRespStatusEnum.FAIL.getCode(), "base.repeated.request"),
        RECORD_NOT_EXIST("99999990", "记录不存在", BaseRespStatusEnum.FAIL.getCode(), "base.record.not.exist"),
        FORBIDDEN("99999403", "服务器理解请求客户端的请求，但是拒绝执行此请求", BaseRespStatusEnum.FAIL.getCode(), "base.server.understands.request.but.refuses.request"),
        INTERNAL_SERVER_ERROR("99999500", "服务器内部错误，无法完成请求", BaseRespStatusEnum.FAIL.getCode(), "base.inner.system.error.unable.complete.request"),
        UNAUTHORIZED("99999401", "token验证失败", BaseRespStatusEnum.FAIL.getCode(), "base.token.verification.failed"),
        REFER_TO_CARD_ISSUER("22070001", "Refer to card issuer", BaseRespStatusEnum.FAIL.getCode(), "refer.to.card.issuer"),
        REFER_TO_CARD_ISSUERS_SPECIAL_CONDITIONS("22070002", "Refer to card issuers special conditions", BaseRespStatusEnum.FAIL.getCode(), "refer.to.card.issuers.special.conditions"),
        INVALID_MERCHANT("22070003", "Invalid merchant", BaseRespStatusEnum.FAIL.getCode(), "invalid.merchant"),
        PICK_UP("22070004", "Pick-up", BaseRespStatusEnum.FAIL.getCode(), "Pick-up"),
        DO_NOT_HONOR("22070005", "Do not honor", BaseRespStatusEnum.FAIL.getCode(), "do.not.honor"),
        ERROR("22070006", "Error", BaseRespStatusEnum.FAIL.getCode(), "error"),
        PICK_UP_CARD("22070007", "Pick-up card, special conditions", BaseRespStatusEnum.FAIL.getCode(), "pick-up.card.special.conditions"),
        HONOR_WITH_IDENTIFICATION("22070008", "Honor with identification", BaseRespStatusEnum.FAIL.getCode(), "honor.with.identification"),
        REQUEST_IN_PROGRESS("22070009", "Request in progress", BaseRespStatusEnum.FAIL.getCode(), "request.in.progress"),
        APPROVED_FOR_PARTIAL_AMOUNT("22070010", "Approved for partial amount", BaseRespStatusEnum.FAIL.getCode(), "approved.for.partial.amount"),
        APPROVED_VIP("22070011", "Approved (VIP)", BaseRespStatusEnum.FAIL.getCode(), "approved.vip"),
        INVALID_TRANSACTION("22070012", "Invalid transaction", BaseRespStatusEnum.FAIL.getCode(), "invalid transaction"),
        INVALID_AMOUNT("22070013", "Invalid amount", BaseRespStatusEnum.FAIL.getCode(), "invalid.amount"),
        INVALID_CARD_NUMBER("22070014", "Invalid card number (no such number)", BaseRespStatusEnum.FAIL.getCode(), "invalid.card.number"),
        NO_SUCH_ISSUER("22070015", "No such issuer", BaseRespStatusEnum.FAIL.getCode(), "no.such.issuer"),
        CUSTOMER_CANCELLATION("22070017", "Customer cancellation, reversal (unsupported)", BaseRespStatusEnum.FAIL.getCode(), "customer.cancellation"),
        CUSTOMER_DISPUTE_CHARGEBACK("22070018", "Customer dispute, chargeback (future)", BaseRespStatusEnum.FAIL.getCode(), "customer.dispute.chargeback"),
        RE_ENTER_TRANSACTION("22070019", "Re-enter transaction", BaseRespStatusEnum.FAIL.getCode(), "re.enter.transaction"),
        INVALID_RESPONSE("22070020", "Invalid response", BaseRespStatusEnum.FAIL.getCode(), "invalid.response"),
        FORMAT_ERROR("22070030", "Format error", BaseRespStatusEnum.FAIL.getCode(), "format.error"),
        BANK_NOT_SUPPORTED("22070031", "Bank not supported by switch", BaseRespStatusEnum.FAIL.getCode(), "bank.not.supported.by.switch"),
        EXPIRED_CARD("22070033", "Expired card, pick-up", BaseRespStatusEnum.FAIL.getCode(), "expired.card"),
        SUSPECTED_FRAUD("22070034", "Suspected fraud, pick-up", BaseRespStatusEnum.FAIL.getCode(), "suspected.fraud"),
        ALLOWABLE_PIN_TRIES_EXCEEDED("22070038", "Allowable PIN tries exceeded, pick-up", BaseRespStatusEnum.FAIL.getCode(), "allowable.PIN.tries.exceeded"),
        NO_CREDIT_ACCOUNT("22070039", "No credit account", BaseRespStatusEnum.FAIL.getCode(), "no.credit.account"),
        REQUESTED_FUNCTION_NOT_SUPPORTED("22070040", "Requested function not supported", BaseRespStatusEnum.FAIL.getCode(), "requested.function.not.supported"),
        LOST_CARD("22070041", "Lost card, pick-up", BaseRespStatusEnum.FAIL.getCode(), "lost.card"),
        STOLEN_CARD("22070043", "Stolen card, pick-up", BaseRespStatusEnum.FAIL.getCode(), "stolen.card"),
        INSUFFICIENT_FUNDS("22070051", "Insufficient funds", BaseRespStatusEnum.FAIL.getCode(), "insufficient.funds"),
        INCORRECT_PIN("22070055", "Incorrect PIN", BaseRespStatusEnum.FAIL.getCode(), "incorrect.PIN"),
        NO_CARD_RECORD("22070056", "No card record", BaseRespStatusEnum.FAIL.getCode(), "No card record"),
        Transaction_not_permitted_to_cardholder("22070057", "Transaction not permitted to cardholder", BaseRespStatusEnum.FAIL.getCode(), "transaction.not.permitted.to.cardholder"),
        CARD_ACCEPTOR_CONTACT_ACQUIRER("22070060", "Card acceptor contact acquirer", BaseRespStatusEnum.FAIL.getCode(), "card.acceptor.contact.acquirer"),
        EXCEEDS_WITHDRAWAL_AMOUNT_LIMIT("22070061", "Exceeds withdrawal amount limit", BaseRespStatusEnum.FAIL.getCode(), "exceeds.withdrawal.amount.limit"),
        SECURITY_VIOLATION("22070063", "Security violation (may also be a chargeback)", BaseRespStatusEnum.FAIL.getCode(), "security.violation"),
        RESTRICTED_CARD("22070062", "Restricted card", BaseRespStatusEnum.FAIL.getCode(), "restricted.card"),
        ORIGINAL_AMOUNT_INCORRECT("22070064", "Original amount incorrect", BaseRespStatusEnum.FAIL.getCode(), "original.amount.incorrect"),
        ALLOWABLE_NUMBER_OF_PIN_TRIES_EXCEEDED("22070075", "Allowable number of PIN tries exceeded", BaseRespStatusEnum.FAIL.getCode(), "allowable.number.of.PIN.tries.exceeded"),
        INVALID_DIGITAL_SIGNATURE("22070079", "Invalid digital signature", BaseRespStatusEnum.FAIL.getCode(), "invalid.digital.signature"),
        STALE_DATED_TRANSACTION("22070080", "Stale dated transaction", BaseRespStatusEnum.FAIL.getCode(), "stale.dated.transaction"),
        CVV_VERIFICATION_FAILED("22070089", "Card verification value (CVV) verification failed (no pickup)", BaseRespStatusEnum.FAIL.getCode(), "CVV.verification.failed"),
        CUTOFF_IS_IN_PROGRESS("22070090", "Cutoff is in progress", BaseRespStatusEnum.FAIL.getCode(), "cutoff.is.in.progress"),
        ISSUER_OR_SWITCH_IS_INOPERATIVE("22070091", "Issuer or switch is inoperative", BaseRespStatusEnum.FAIL.getCode(), "Issuer.or.switch.is.inoperative"),
        DUPLICATION_TRANSACTION("22070094", "Duplication transaction", BaseRespStatusEnum.FAIL.getCode(), "reconcile.error"),
        RECONCILE_ERROR("22070095", "Reconcile error", BaseRespStatusEnum.FAIL.getCode(), "reconcile.error"),
        SYSTEM_MALFUNCTION("22070096", "System malfunction", BaseRespStatusEnum.FAIL.getCode(), "system.malfunction"),
        UNCION_OR_SERVICE_NO_ENABLED("22070349", "Function/service not enabled Please contact the merchant", BaseRespStatusEnum.FAIL.getCode(), "uncion.or.service.no.enabled"),
        SETTLEMENT_ACCOUNT_IS_NOT_CONFIGURED("22070350", "Settlement account is not configured", BaseRespStatusEnum.FAIL.getCode(), "settlement.account.is.not.configured"),
        RATE_NOT_CONFIGURED("22070351", "Rate not configured", BaseRespStatusEnum.FAIL.getCode(), "rate.not.configured"),
        EXCHANGE_RATE_NOT_CONFIGURED("22070352", "Exchange rate not configured", BaseRespStatusEnum.FAIL.getCode(), "exchange.rate.not.configured"),
        ROUTING_NOT_CONFIGURED("22070353", "Routing not configured", BaseRespStatusEnum.FAIL.getCode(), "routing.not.configured"),
        TRANSACTION_DOES_NOT_EXIST("22070354", "Transaction does not exist", BaseRespStatusEnum.FAIL.getCode(), "transaction.does.not.exist"),
        NOT_FOUND("99999404", "服务器无法根据客户端的请求找到资源", BaseRespStatusEnum.FAIL.getCode(), "base.server.cannot.find.resource.according.client.request");

        private String status;
        private String code;
        private String message;
        private String i18nMessage;

        public String getI18nMessage() {
            MessageUtils messageUtils = (MessageUtils) ApplicationContextHelper.getBean(MessageUtils.class);
            String i18n = messageUtils.get(this.i18nMessage);
            return i18n;
        }

        public void setI18nMessage(String i18nMessage) {
            this.i18nMessage = i18nMessage;
        }

        private BaseRespCodeEnum(String code, String message, String status, String i18nMessage) {
            this.code = code;
            this.message = message;
            this.status = status;
            this.i18nMessage = i18nMessage;
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCode() {
            return this.code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

}
