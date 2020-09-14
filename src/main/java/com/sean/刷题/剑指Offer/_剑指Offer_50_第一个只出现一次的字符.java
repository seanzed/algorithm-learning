package com.sean.刷题.剑指Offer;

import java.util.HashMap;

/**
 * _剑指Offer_50_第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *  
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 50000
 *
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 *
 * @author chenxu
 * @summary _剑指Offer_50_第一个只出现一次的字符
 * @since 2020-09-10 08:58
 */
public class _剑指Offer_50_第一个只出现一次的字符 {

    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> dict = new HashMap<>();
        char[] sc = s.toCharArray();
        for (char c : sc) {
            dict.put(c, !dict.containsKey(c));
        }

        for (char c : sc) {
            if (dict.get(c)) return c;
        }
        return ' ';
    }
}
