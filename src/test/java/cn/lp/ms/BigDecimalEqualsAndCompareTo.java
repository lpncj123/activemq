package cn.lp.ms;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.ms
 * @Author: lp
 * @CreateTime: 2025-12-18  15:24
 * @Description: TODO
 * @Version: 1.0
 */
public class BigDecimalEqualsAndCompareTo {
    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("1.10");
        BigDecimal b2 = new BigDecimal("1.1");
        System.out.println(b1.compareTo(b2));
//        equals会比较BigDecimal的标位Scale
        System.out.println(b1.equals(b2));


    }
}
