package cn.lp.utils;

public enum TycStyle {
    SUCCESS("0","请求成功"),
    NO_DATA("300000","无数据"),
    FAIL("300001","请求失败"),
    ACCOUNT_INVALID("300002","账号失效"),
    ACCOUNT_EXPIRED("300003","账号过期"),
    ACCOUNT_EXPIRD("300003","访问频率"),
    ;
    private final String code;
    private final String message;

    TycStyle(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
