package cn.lp;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: PACKAGE_NAME
 * @Author: lp
 * @CreateTime: 2026-01-07  17:58
 * @Description: TODO
 * @Version: 1.0
 */
public enum PaymentErrorIsoEnum {
    AWX_PAY_ERROR("awx_pay_error", "05", "10050001", "您的付款被拒绝了。您可以从另一个账户支付，或选择另一种支付方式。", "Your payment was declined. You can pay from another account or choose a different payment method."),
    PROVIDER_DECLINED("provider_declined", "57", "50570001", "此支付方式暂时不可用。请使用其他支付方式重试。", "This payment method is temporarily unavailable. Please try again with a different payment method."),
    INTERNAL_ERROR("internal_error", "96", "10960001", "发生未知错误，请稍后重试。", "An unknown error occurred, please try again later."),
    VALIDATION_ERROR("validation_error", "14", "20140001", "输入无效。请确认您的支付信息后重试。", "Invalid input. Please verify your payment information and try again."),
    VALIDATION_ERROR_INVALID_PAN("validation_error.invalid_pan", "14", "20140002", "您的卡号无效，请确认后重试。", "Your card number is invalid, please verify and try again."),
    CONFIGURATION_ERROR("configuration_error", "12", "10120001", "您的支付未成功，请联系商家寻求帮助。", "Your payment was not successful, please contact the merchant for assistance."),
    SERVICE_UNAVAILABLE("service_unavailable", "91", "50910001", "发生未知错误，请稍后重试。", "An unknown error occurred, please try again later."),
    PROCESSOR_DECLINED("processor_declined", "06", "10060001", "发生未知错误，请稍后重试。", "An unknown error occurred, please try again later."),
    PROCESSOR_UNAVAILABLE("processor_unavailable", "91", "50910002", "发生未知错误，请稍后重试。", "An unknown error occurred, please try again later."),
    PROVIDER_UNAVAILABLE("provider_unavailable", "57", "50570002", "此支付方式暂时不可用。请使用其他支付方式重试。", "This payment method is temporarily unavailable. Please try again with a different payment method."),
    ISSUER_UNAVAILABLE("issuer_unavailable", "91", "50910003", "此支付方式暂时不可用。请使用其他支付方式重试。", "This payment method is temporarily unavailable. Please try again with a different payment method."),
    RISK_DECLINED("risk_declined", "59", "30590001", "支付已拒绝。请验证您的详细信息或尝试使用其他支付方式。", "Payment declined. Please verify your details or try a different payment method."),
    AUTHENTICATION_DECLINED("authentication_declined", "61", "60610001", "您未能成功验证付款。请重试，如果重试失败，请联系您的发卡行或切换至其他支付方式。", "You failed to authenticate the payment. Please try again, or contact your issuer or switch to another payment method if it fails again."),
    NO_3DS_LIABILITY_SHIFT("no_3ds_liability_shift", "61", "60610002", "您的发卡行目前无法进行支付验证。请联系发卡行或尝试使用其他支付方式。", "Your issuer is currently unable to verify the payment. Please contact the issuer or try a different payment method."),
    QUOTE_EXPIRED("quote_expired", "54", "50540001", "此支付信息已过期，请重新支付。", "This payment information has expired, please make the payment again."),
    AMOUNT_ABOVE_LIMIT("amount_above_limit", "61", "40610001", "您的支付金额超出允许的交易限额，请联系商家。", "Your payment amount exceeds the allowed transaction limit, please contact the merchant."),
    AMOUNT_BELOW_LIMIT("amount_below_limit", "62", "40620001", "您的支付金额低于允许的交易限额，请联系商家。", "Your payment amount is below the allowed transaction limit, please contact the merchant."),
    ISSUER_ERROR_EXCEED_MERCHANT_LIMIT("issuer_error.exceed_merchant_limit", "61", "40610002", "您的支付金额超出商家允许的限额，请联系商家。", "Your payment amount exceeds the merchant's allowed limit, please contact the merchant."),
    FREQUENCY_ABOVE_LIMIT("frequency_above_limit", "65", "40650001", "您的支付次数超出商家允许的限额，请联系商家。", "Your payment frequency exceeds the merchant's allowed limit, please contact the merchant."),
    RESOURCE_NOT_FOUND("resource_not_found", "25", "10250001", "发生未知错误，请稍后重试。", "An unknown error occurred, please try again later."),
    RESOURCE_ALREADY_EXISTS("resource_already_exists", "94", "10940001", "该卡此前已被保存，您无需再次输入卡号即可直接完成付款。", "This card has already been saved; you can complete the payment directly without re-entering the card number."),
    VERIFICATION_EXPIRED("verification_expired", "54", "50540002", "该验证链接已过期。请请求一个新的链接并重试。", "This verification link has expired. Please request a new link and try again."),
    DUPLICATE_REQUEST("duplicate_request", "94", "10940002", "您的付款请求无效，请重试。", "Your payment request is invalid, please try again."),
    INVALID_STATUS_FOR_OPERATION("invalid_status_for_operation", "12", "10120002", "发生未知错误，请稍后重试。", "The PaymentIntent status SUCCEEDED is invalid for operation confirm."),
    OPERATION_NOT_SUPPORTED("operation_not_supported", "57", "50570003", "发生unknown错误，请稍后重试。", "An unknown error occurred, please try again later."),
    CURRENCY_NOT_SUPPORTED("currency_not_supported", "58", "50580001", "暂不支持此币种，请联系商家。", "This currency is not supported, please contact the merchant."),
    CARD_BRAND_NOT_SUPPORTED("card_brand_not_supported", "57", "50570004", "此支付方式暂时不可用。请使用其他支付方式重试。", "This payment method is temporarily unavailable. Please try again with a different payment method."),
    REJECTED_BY_ROUTING_RULES("rejected_by_routing_rules", "57", "50570005", "此支付方式暂时不可用。请使用其他支付方式重试。", "This payment method is temporarily unavailable. Please try again with a different payment method."),
    THREE_DS_NOT_SUPPORTED("3ds_not_supported", "61", "60610003", "该支付方式不支持 3DS 安全验证。请使用另一张支持该验证的卡重新付款。", "This payment method does not support 3DS security verification. Please use another card that supports this verification."),
    PAYMENT_METHOD_NOT_ALLOWED("payment_method_not_allowed", "57", "50570006", "暂不支持此支付方式，请联系商家。", "This payment method is not supported, please contact the merchant."),
    SUSPENDED_FROM_ONLINE_PAYMENTS("suspended_from_online_payments", "63", "30630001", "您的支付被阻止，请联系商家。", "Your payment has been blocked, please contact the merchant."),
    STATE_INVALID_FOR_OPERATION("state_invalid_for_operation", "12", "10120003", "您的交易被阻止，请联系商家。", "Your transaction has been blocked, please contact the merchant."),
    NO_PAYMENT_METHODS("no_payment_methods", "57", "50570007", "没有可用的支付方式。", "No payment methods are available."),
    UNAUTHORIZED("unauthorized", "61", "60610004", "验证失败。", "Authentication failed."),
    ISSUER_ERROR_ISSUER_DECLINED("issuer_error.issuer_declined", "05", "30050001", "您的发卡行已拒绝该交易。请联系发卡行或尝试其他支付方式。", "Your issuer has declined this transaction. Please contact your issuer or try a different payment method."),
    ISSUER_ERROR_ERROR_WITH_PAYMENT("issuer_error.error_with_payment", "06", "30060001", "您的支付发生错误，请联系您的发卡行。", "An error occurred with your payment, please contact your issuer."),
    ISSUER_ERROR_EXCEED_LIMIT("issuer_error.exceed_limit", "61", "40610003", "您的支付金额超出可交易的限额。请联系您的发卡行 alterations。", "Your payment amount exceeds the transaction limit. Please contact your issuer to update settings."),
    ISSUER_ERROR_EXCEED_LIMIT_1("issuer_error.exceed_limit_1", "61", "40610004", "您的发卡行已拒绝该交易因为支付金额超出可交易的限额。请联系发卡行或尝试其他支付方式。", "Your issuer has declined this transaction because the payment amount exceeds the transaction limit. Please contact your issuer or try a different payment method."),
    ISSUER_ERROR_SUSPECTED_FRAUD("issuer_error.suspected_fraud", "59", "30590002", "支付发生错误，请联系您的发卡行寻求帮助。", "An error occurred with your payment, please contact your issuer for assistance."),
    ISSUER_ERROR_PAYMENT_METHOD_UNAVAILABLE("issuer_error.payment_method_unavailable", "57", "50570008", "此支付方式暂时不可用。请使用其他支付方式重试。", "This payment method is temporarily unavailable. Please try again with a different payment method."),
    ISSUER_ERROR_CARD_NUMBER_INVALID("issuer_error.card_number_invalid", "14", "20140003", "您的卡号无效，请检查卡信息并重试。", "Your card number is invalid, please check the card information and try again."),
    ISSUER_ERROR_INSUFFICIENT_FUNDS("issuer_error.insufficient_funds", "51", "30510001", "此卡可用余额不足，请充值后重试。", "This card has insufficient funds, please top up and try again."),
    ISSUER_ERROR_CARD_EXPIRED("issuer_error.card_expired", "54", "50540003", "此卡已过期，请更新卡信息后重试。", "This card has expired, please update the card information and try again."),
    ISSUER_ERROR_INCORRECT_PIN("issuer_error.incorrect_pin", "55", "50550001", "PIN 码不正确，请重新输入有效的 PIN 码并重试。", "The PIN code is incorrect, please enter a valid PIN code and try again."),
    ISSUER_ERROR_EXCEED_FREQUENCY_LIMIT("issuer_error.exceed_frequency_limit", "65", "40650002", "此卡已超出支付频率限制，请联系您的发卡行解决此问题后再试。", "This card has exceeded the payment frequency limit, please contact your issuer to resolve this issue and try again."),
    ISSUER_ERROR_CARD_NOT_ACTIVATED("issuer_error.card_not_activated", "57", "50570009", "此卡尚未激活，请激活后重试。", "This card has not been activated, please activate it and try again."),
    ISSUER_ERROR_INVALID_3_DIGIT("issuer_error.invalid_3_digit", "14", "20140004", "安全码无效，请输入有效的 3 位数号码并重试。", "The security code is invalid, please enter a valid 3-digit code and try again."),
    ISSUER_ERROR_INVALID_4_DIGIT("issuer_error.invalid_4_digit", "14", "20140005", "安全码无效，请输入有效的 4 位数号码并重试。", "The security code is invalid, please enter a valid 4-digit code and try again."),
    ISSUER_ERROR_INVALID_EXPIRY("issuer_error.invalid_expiry", "54", "50540004", "此卡有效期已失效，请更新卡信息后重试。", "This card's expiry date is invalid, please update the card information and try again."),
    PAYMENT_CHANNEL_UNAVAILABLE("payment_channel_unavailable", "92", "10920010", "支付渠道暂时不可用，请尝试其他支付渠道。", "The payment channel is temporarily unavailable, please try another payment channel."),
    MERCHANT_NOT_REGISTERED("merchant_not_registered", "03", "10030011", "商户未在支付渠道报备，请联系商家或支付渠道。", "The merchant is not registered with the payment channel, please contact the merchant or payment channel.");

    private final String code;
    private final String iso8583Code;
    private final String extendedCode;
    private final String zhMessage;
    private final String enMessage;

    private PaymentErrorIsoEnum(String code, String iso8583Code, String extendedCode, String zhMessage, String enMessage) {
        this.code = code;
        this.iso8583Code = iso8583Code;
        this.extendedCode = extendedCode;
        this.zhMessage = zhMessage;
        this.enMessage = enMessage;
    }

    public String getCode() {
        return this.code;
    }

    public String getIso8583Code() {
        return this.iso8583Code;
    }

    public String getExtendedCode() {
        return this.extendedCode;
    }

    public String getZhMessage() {
        return this.zhMessage;
    }

    public String getEnMessage() {
        return this.enMessage;
    }

    public static PaymentErrorIsoEnum fromCode(String code) {
        for(PaymentErrorIsoEnum error : values()) {
            if (error.code.equals(code)) {
                return error;
            }
        }

        throw new IllegalArgumentException("Unknown payment error code: " + code);
    }

    public static PaymentErrorIsoEnum fromIso8583Code(String iso8583Code) {
        for(PaymentErrorIsoEnum error : values()) {
            if (error.iso8583Code.equals(iso8583Code)) {
                return error;
            }
        }

        throw new IllegalArgumentException("Unknown ISO 8583 response code: " + iso8583Code);
    }

    public static PaymentErrorIsoEnum fromExtendedCode(String extendedCode) {
        for(PaymentErrorIsoEnum error : values()) {
            if (error.extendedCode.equals(extendedCode)) {
                return error;
            }
        }

        throw new IllegalArgumentException("Unknown extended error code: " + extendedCode);
    }
}
