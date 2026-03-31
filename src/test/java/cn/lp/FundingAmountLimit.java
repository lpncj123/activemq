package cn.lp;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp
 * @Author: lp
 * @CreateTime: 2026-01-06  17:49
 * @Description: TODO
 * @Version: 1.0
 */

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
public enum FundingAmountLimit {

    CNY("CNY", new BigDecimal("3"), new BigDecimal("10000")),
    USD("USD", new BigDecimal("0.5"), new BigDecimal("1500")),
    HKD("HKD", new BigDecimal("3"), new BigDecimal("11000")),
    MYR("MYR", new BigDecimal("1"), new BigDecimal("6500")),
    IDR("IDR", new BigDecimal("2200"), new BigDecimal("22000000")),
    KRW("KRW", new BigDecimal("200"), new BigDecimal("2000000")),
    THB("THB", new BigDecimal("5"), new BigDecimal("50000")),
    PHP("PHP", new BigDecimal("10"), new BigDecimal("80000")),
    BRL("BRL", new BigDecimal("1"), new BigDecimal("5000"));

    private final String currency;
    private final BigDecimal minAmount;
    private final BigDecimal maxAmount;

    // 快速查找用的 Map
    private static final Map<String, FundingAmountLimit> BY_CURRENCY = new HashMap<>();

    static {
        for (FundingAmountLimit limit : values()) {
            BY_CURRENCY.put(limit.currency, limit);
        }
    }

    FundingAmountLimit(String currency, BigDecimal minAmount, BigDecimal maxAmount) {
        this.currency = currency;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    /**
     * 根据货币代码获取对应的金额限制
     * @param currency 货币代码，如 "PHP"
     * @return 对应的枚举实例，如果不存在返回 null
     */
    public static FundingAmountLimit getByCurrency(String currency) {
        if (currency == null) {
            return null;
        }
        return BY_CURRENCY.get(currency.toUpperCase());
    }

    /**
     * 获取最小金额（字符串格式，常用于展示）
     */
    public String getMinAmountStr() {
        return minAmount.stripTrailingZeros().toPlainString();
    }

    /**
     * 获取最大金额（字符串格式，常用于展示）
     */
    public String getMaxAmountStr() {
        return maxAmount.stripTrailingZeros().toPlainString();
    }
}