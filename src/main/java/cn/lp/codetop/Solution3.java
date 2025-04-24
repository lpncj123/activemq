package cn.lp.codetop;

import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.codetop
 * @Author: lp
 * @CreateTime: 2024-07-03  17:56
 * @Description: TODO
 * @Version: 1.0
 */
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int rk = -1,ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !set.contains(s.charAt(rk + 1))) {
                set.add(s.charAt(rk + 1));
                rk++;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
