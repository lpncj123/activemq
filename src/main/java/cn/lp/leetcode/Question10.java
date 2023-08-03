package cn.lp.leetcode;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.leetcode
 * @Author: lp
 * @CreateTime: 2023-08-03  14:43
 * @Description: TODO
 * @Version: 1.0
 */
public class Question10 {
    public static boolean isMatch(String s, String p) {
        int m = s.length();  // 字符串 s 的长度
        int n = p.length();  // 正则表达式 p 的长度
        boolean[][] dp = new boolean[m + 1][n + 1];  // 动态规划数组，dp[i][j] 表示 s 前 i 个字符和 p 前 j 个字符是否匹配
        dp[0][0] = true;  // 初始化，空字符串与空正则表达式匹配

        // 填充动态规划数组
        for (int i = 0; i <= m; i++) { //ab
            for (int j = 1; j <= n; j++) { //a*
                if (p.charAt(j - 1) == '*') {
                    // 当前字符为 '*'，有两种情况：
                    // 1. 忽略 '*' 和它前面的字符，即 dp[i][j] = dp[i][j - 2]，例如匹配 ab 和 a* 的情况
                    // 2. 当前字符匹配，且前一个字符匹配或为 '.'，即 dp[i][j] = dp[i - 1][j]，例如匹配 aab 和 a*b 的情况
                    dp[i][j] = dp[i][j - 2] || (i > 0 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j]);
                } else {
                    // 当前字符不为 '*'，若当前字符匹配，且前一个字符匹配或为 '.'，则 dp[i][j] = dp[i - 1][j - 1]
                    dp[i][j] = i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') && dp[i - 1][j - 1];
                }
            }
        }

        return dp[m][n];  // 返回结果，即 s 的前 m 个字符和 p 的前 n 个字符是否匹配
    }

    public static void main(String[] args) {
        String s = "ab";
        String p = "a*";
        boolean result = isMatch(s, p);
        System.out.println(result); // Output: false
    }
}
