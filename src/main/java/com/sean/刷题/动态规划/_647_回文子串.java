package com.sean.刷题.动态规划;

/**
 * _647_回文子串 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："abc" 输出：3 解释：三个回文子串: "a", "b", "c" 示例 2：
 *
 * 输入："aaa" 输出：6 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 *
 * @author chenxu
 * @summary _647_回文子串
 * @since 2020-08-24 12:45
 */
public class _647_回文子串 {

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[chars.length][chars.length];
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1] == true)) {
                    dp[j][i] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
}
