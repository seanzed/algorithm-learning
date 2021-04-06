package com.sean.刷题.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * _剑指Offer_38_字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 *
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 *
 *
 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 *
 * 限制：
 *
 * 1 <= s 的长度 <= 8
 *
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 *
 * @author chenxu
 * @summary _剑指Offer_38_字符串的排列
 * @since 2020-12-16 23:48
 */
public class _剑指Offer_38_字符串的排列 {

    public String[] permutation(String s) {
        if (s == null) return null;
        if (s.length() == 0) return new String[0];
        List<String> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        dsf(0, chars, list);
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void dsf(int idx, char[] chars, List<String> list) {
        // 判断是否结束
        if (idx == chars.length) {
            StringBuilder sb = new StringBuilder();
            for (char c: chars) {
                sb.append(c);
            }
            list.add(sb.toString());
        }

        for (int i = idx; i < chars.length; i++) {
            if (isRepeat(chars, idx, i)) continue;
            swap(chars, idx, i);
            dsf(idx + 1, chars, list);
            swap(chars, idx, i);
        }
    }

    private Boolean isRepeat(char[] chars, int idx, int i) {
        for (int j = idx; j < i; j++) {
            if (chars[j] == chars[i]) return true;
        }
        return false;
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        _剑指Offer_38_字符串的排列 test = new _剑指Offer_38_字符串的排列();
        String[] strings = test.permutation("a");
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
