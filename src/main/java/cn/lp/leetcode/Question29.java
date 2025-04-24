package cn.lp.leetcode;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.leetcode
 * @Author: lp
 * @CreateTime: 2024-01-25  16:08
 * @Description: TODO
 * @Version: 1.0
 */
public class Question29 {
    public int divide(int dividend, int divisor) {
//        处理临界范围，防止溢出（考虑正负数范围不一致）
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
//        这里使用了位异或运算符 ^，如果两者符号相异，结果为 true，否则为 false
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        int absDividend = Math.abs(dividend);
        int absDivisor = Math.abs(divisor);
        int result = 0;
        while (absDividend >= absDivisor) {
            int temp = absDivisor, multiple = 1;
            while (absDividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;

            }
            absDividend -= temp;
            result += multiple;
        }
        return sign * result;
    }
}
