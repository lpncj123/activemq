package cn.lp;

public enum TargetOrgEnum {
    WECHATPAY("wechatpay", "QRPH"),                     // 原值 -> 展示值
    KOREAN_CARDS("korean_cards", "KOREAN_CARDS"),
    // 其他值按需添加
    UNKNOWN("unknown", "UNKNOWN");

    private final String rawValue;
    private final String displayValue;

    TargetOrgEnum(String rawValue, String displayValue) {
        this.rawValue = rawValue;
        this.displayValue = displayValue;
    }

    public static String getDisplayValue(String raw) {
        if (raw == null) return null;
        for (TargetOrgEnum e : values()) {
            if (e.rawValue.equalsIgnoreCase(raw)) {
                return e.displayValue;
            }
        }
        return raw.toUpperCase(); // fallback
    }
}
