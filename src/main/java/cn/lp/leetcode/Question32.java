package cn.lp.leetcode;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.leetcode
 * @Author: lp
 * @CreateTime: 2024-01-31  15:56
 * @Description: TODO
 * @Version: 1.0
 */
public class Question32 {
    public static int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        int[] dp = new int[s.length()]; // dp[i]：严格以i位置结尾，形成的有效括号子串最长长度是多少
        int max = 0; // 最终的答案

        // dp[0] = 0; // 默认

        for (int i = 1; i < s.length(); i++) {
            // if (s.charAt(i) == '(') dp[i] = 0; 以左括号结尾，无效

            if (s.charAt(i) == ')') {
                int preLen = dp[i - 1]; // 前面已经形成的有效括号长度
                int pre = i - 1 - preLen; // 寻找与当前的右括号相匹配的左括号位置：前面有效括号长度再往前一个位置,如果前面都是无效位置，就找前一位

                if (pre >= 0 && s.charAt(pre) == '(') { // 如果寻找到左括号：前面有效括号长度再往前一个位置是左括号
                    dp[i] = dp[i-1] + 2; // 可以与当前的右括号闭合，有效长度增加2。


                    // 例如()(()())情况下，dp[7]已经等于 dp[6]+2 = 4+2。还需要在往前看一位，()()同理，后面加上前一位的括号数量
                    if (pre-1 >= 0) {
                        dp[i] += dp[pre-1];
                    }
                }

                max = Math.max(max, dp[i]); // 严格以每个结尾抓一个答案，最终答案必在其中
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(Question32.longestValidParentheses("()(()())"));
    }
}
