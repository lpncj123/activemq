package cn.lp.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.leetcode
 * @Author: lp
 * @CreateTime: 2024-01-25  17:55
 * @Description: TODO
 * @Version: 1.0
 */
public class Question30 {
    // 主方法，用于找到符合条件的子串的开始索引
//    public static List<Integer> findSubstring(String s, String[] words) {
//        List<Integer> result = new ArrayList<>();
//        if (s == null || s.isEmpty() || words == null || words.length == 0) {
//            return result;
//        }
//
//        int wordLen = words[0].length(); // 单词的长度
//        int totalLen = wordLen * words.length; // 拼接所有单词后的总长度
//
//        // 统计每个单词在 words 数组中的出现次数
//        Map<String, Integer> wordCount = new HashMap<>();
//        for (String word : words) {
//            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
//        }
//
//        // 遍历字符串 s 的所有可能子串
//        for (int i = 0; i <= s.length() - totalLen; i++) {
//            // 如果当前子串符合条件，将其开始索引添加到结果列表中
//            if (isConcatenation(s.substring(i, i + totalLen), wordCount, wordLen)) {
//                result.add(i);
//            }
//        }
//
//        return result;
//    }
//
//    // 判断某个子串是否包含了 words 中的所有单词并且顺序正确
//    private static boolean isConcatenation(String s, Map<String, Integer> wordCount, int wordLen) {
//        // 用于存储当前子串中每个单词的出现次数
//        Map<String, Integer> seen = new HashMap<>();
//
//        // 遍历子串，每次取一个单词的长度
//        for (int i = 0; i < s.length(); i += wordLen) {
//            String word = s.substring(i, i + wordLen);
//            seen.put(word, seen.getOrDefault(word, 0) + 1); // 计数当前单词出现的次数
//        }
//
//        // 检查当前子串中每个单词的出现次数是否与 wordCount 相等
//        return seen.equals(wordCount);
//    }
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.isEmpty() || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length(); // 单词的长度
        int totalLen = wordLen * words.length; // 拼接所有单词后的总长度

        // 统计每个单词在 words 数组中的出现次数
        Map<String, Integer> wordCount = new HashMap<>(16);
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // 遍历每个可能的起始位置、这里循环因为数组的字符长度比如为3，那么0,1,2都可以作为起始位置开始，然后进入循环开始滑动这个位置的窗口，找出对应的字符串。
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i, count = 0;
            Map<String, Integer> window = new HashMap<>(16);

            // 开始滑动窗口
            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (!wordCount.containsKey(word)) {
                    // 遇到不在 words 数组中的单词，重置窗口
                    window.clear();
                    count = 0;
                    left = right;
                } else {
                    // 将单词加入窗口
                    window.put(word, window.getOrDefault(word, 0) + 1);
                    count++;

                    // 检查窗口中的单词是否超过了在 words 中的次数
                    while (window.get(word) > wordCount.getOrDefault(word, 0)) {
                        String leftWord = s.substring(left, left + wordLen);
                        window.put(leftWord, window.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    // 如果窗口中的单词数与 words 中的总数相等，表示找到符合条件的子串
                    if (count == words.length) {
                        result.add(left);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
