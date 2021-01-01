package com.sean.刷题.字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * _3_无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的  最长子串  的长度。
 *
 * 示例  1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是  "wke"，所以其长度为 3。
 *       请注意，你的答案必须是 子串 的长度，"pwke"  是一个子序列，不是子串。
 *
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 *
 * @author chenxu
 * @summary _3_无重复字符的最长子串
 * @since 2020-11-18 23:45
 */
public class _3_无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();

        // 用来保存每一个字符上一次出现的位置
        int[] prevIdxes = new int[128];
        for (int i = 0; i < prevIdxes.length; i++) {
            prevIdxes[i] = -1;
        }
        prevIdxes[chars[0]] = 0;
        // 以i - 1位置字符结尾的最长不重复字符串的开始索引（最左索引）
        int li = 0;
        int max = 1;
        for (int i = 1; i < chars.length; i++) {
            // i位置字符上一次出现的位置
            int pi = prevIdxes[chars[i]];
            if (li <= pi) {
                li = pi + 1;
            }
            // 存储这个字符出现的位置
            prevIdxes[chars[i]] = i;
            // 求出最长不重复子串的长度
            max = Math.max(max, i - li + 1);
        }
        return max;
    }

    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();

        // 用来保存每一个字符上一次出现的位置
        Map<Character, Integer> prevIdxes = new HashMap<>();
        prevIdxes.put(chars[0], 0);
        // 以i - 1位置字符结尾的最长不重复字符串的开始索引（最左索引）
        int li = 0;
        int max = 1;
        for (int i = 1; i < chars.length; i++) {
            // i位置上一次出现的位置
            Integer pi = prevIdxes.get(chars[i]);
            if (pi != null && li <= pi) {
                li = pi + 1;
            }

            prevIdxes.put(chars[i], i);
            // 求出最长不重复子串的长度
            max = Math.max(max, i - li + 1);
        }
        return max;
    }
}
