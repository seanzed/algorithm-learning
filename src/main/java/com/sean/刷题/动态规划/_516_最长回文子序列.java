package com.sean.刷题.动态规划;

/**
 * _516_最长回文子序列 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 *
 *
 *
 * 示例 1: 输入:
 *
 * "bbbab" 输出:
 *
 * 4 一个可能的最长回文子序列为 "bbbb"。
 *
 * 示例 2: 输入:
 *
 * "cbbd" 输出:
 *
 * 2 一个可能的最长回文子序列为 "bb"。
 *
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000 s 只包含小写英文字母
 *
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-subsequence
 *
 * @author chenxu
 * @summary _516_最长回文子序列
 * @since 2020-08-28 13:51
 */
public class _516_最长回文子序列 {

    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) return 0;

        char[] sChars = s.toCharArray();

        int size = sChars.length;
        int[][] dp = new int[size][size];
        for (int i = 0; i < size; i++) {
            dp[i][i] = 1;
        }

        // 按状态转移方程填表
        for (int len = 2; len <= size; len++) {
            for (int i = 0; i <= size - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 2);
                }
            }
        }
        return dp[0][size - 1];
    }
}
