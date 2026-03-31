package cn.lp;/**
*@BelongsProject: activemq
*@BelongsPackage: cn.lp
*@Author: lp
*@CreateTime: 2026-01-06  17:52
*@Description: TODO
*@Version: 1.0
*/
import java.util.HashMap;
import java.util.Map;

public enum WalletTypeEnum {
    WECHAT_PAY("wechatpay", "WEIXIN", "WeChat Pay, a popular Chinese mobile payment app"),
    UNION_PAY("unionpay", "UNIONPAY", "UnionPay, a Chinese bank card organization"),
    ALIPAY_CN("alipaycn", "ALIPAY_CN", "Alipay China, a leading Chinese online payment platform"),
    BANK_TRANSFER("bank_transfer", "BANK_TRANSFER", "银行转账"),
    CARD("card", "CARD", "国际卡"),
    KOREAN_CARDS("korean_cards", "KOREAN_CARDS", "Korean Cards"),
    ALIPAY_HK("alipayhk", "ALIPAY_HK", "Alipay Hong Kong, a regional version of Alipay"),
    GCASH("gcash", "GCASH", "GCash, a mobile wallet in the Philippines"),
    BPI("bpi", "BPI", "Bank of the Philippine Islands mobile banking"),
    TNG("tng", "TNG", "Touch 'n Go, a Malaysian e-wallet"),
    BOOST("boost", "BOOST", "Boost, a Malaysian mobile payment app"),
    DANA("dana", "DANA", "DANA, an Indonesian digital wallet"),
    KAKAOPAY("kakaopay", "KAKAOPAY", "KakaoPay, a South Korean mobile payment service"),
    KHIPU("khipu", "Khipu", "Khipu, a Chilean payment platform"),
    RABBIT_LINE_PAY("rabbit_line_pay", "RABBIT_LINE_PAY", "Rabbit LINE Pay, a Thai mobile payment service"),
    TRUEMONEY("truemoney", "TRUEMONEY", "Truemoney, a Thai mobile payment service"),
    NAVER_PAY("naver_pay", "NAVERPAY", "Naver Pay, a South Korean online payment service"),
    TOSS_PAY("toss_pay", "TOSSPAY", "Toss Pay, a South Korean mobile payment app"),
    MAYA("maya", "MAYA", "Maya, a Philippine digital payment platform"),
    BILLEASE("billease", "BILLEASE", "BillEase, a Philippine installment payment service"),
    GO_PAY("go_pay", "GoPay", "GoPay, an Indonesian e-wallet by Gojek"),
    OVO("ovo", "OVO", "OVO, an Indonesian digital payment service"),
    DOKU_EWALLET("doku_ewallet", "DOKU", "DOKU, an Indonesian e-wallet"),
    DRAGONPAY("dragonpay", "Dragonpay", "Dragonpay, a Philippine online payment gateway"),
    KONBINI("konbini", "Konbini", "Konbini, Japanese convenience store payment"),
    PAYEASY("payeasy", "PayEasy", "PayEasy, a Japanese online payment method"),
    GRABPAY("grabpay", "GrabPay", "GrabPay, a Southeast Asian mobile wallet by Grab"),
    PAYCO("payco", "PAYCO", "PAYCO, a South Korean payment service"),
    MPAY("mpay", "MPAY", "MPay, a Macau-based mobile payment service"),
    PROMPT_PAY("prompt_pay", "PROMPT_PAY", "PromptPay, Thailand's national e-payment system"),
    HIPAY("hi_pay", "HIPAY", "HiPay, a European payment platform"),
    TINABA("tinaba", "TINABA", "Tinaba, an Italian digital wallet"),
    KPLUS("kplus", "KPLUS", "K PLUS, a Vietnamese mobile banking app by KBank"),
    QRPH("qrph", "QRPH", "QR Ph is the Philippines’ QR code standard based on the Europay-Mastercard-VISA (EMV)\nstandard");

    private final String originalType;
    private final String targetType;
    private final String description;
    private static final Map<String, WalletTypeEnum> ORIGINAL_TYPE_LOOKUP = new HashMap();
    private static final Map<String, WalletTypeEnum> TARGET_TYPE_LOOKUP = new HashMap();

    private WalletTypeEnum(String originalType, String targetType, String description) {
        this.originalType = originalType;
        this.targetType = targetType;
        this.description = description;
    }

    public String getOriginalType() {
        return this.originalType;
    }

    public String getTargetType() {
        return this.targetType;
    }

    public String getDescription() {
        return this.description;
    }

    public static WalletTypeEnum fromOriginalType(String originalType) {
        return (WalletTypeEnum)ORIGINAL_TYPE_LOOKUP.get(originalType.toLowerCase());
    }

    public static WalletTypeEnum fromTargetType(String targetType) {
        return (WalletTypeEnum)TARGET_TYPE_LOOKUP.get(targetType.toLowerCase());
    }

    static {
        WalletTypeEnum[] var0 = values();
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            WalletTypeEnum walletType = var0[var2];
            ORIGINAL_TYPE_LOOKUP.put(walletType.originalType.toLowerCase(), walletType);
            TARGET_TYPE_LOOKUP.put(walletType.targetType.toLowerCase(), walletType);
        }

    }
}