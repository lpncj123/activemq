package cn.lp.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.leetcode
 * @Author: lp
 * @CreateTime: 2024-01-29  17:23
 * @Description: TODO
 * @Version: 1.0
 */
public class Question30self {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.isEmpty() || words == null || words.length == 0) {
            return result;
        }
        int wordLen = words[0].length();
        Map<String, Integer> wordCount = new HashMap<>(16);
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < wordLen; i++) {
            Map<String, Integer> window = new HashMap<>(16);
            int left = i, right = i, count = 0;
            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;
                if (!wordCount.containsKey(word)) {
                    window.clear();
                    count = 0;
                    left = right;
                } else {
                    window.put(word, window.getOrDefault(word, 0) + 1);
                    count++;
                    while (window.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        window.put(leftWord, window.get(leftWord) - 1);
                        count--;
                        left += wordLen;

                    }
                    if (count == words.length) {
                        result.add(left);
                    }
                }
            }
        }

        return result;
    }
}
