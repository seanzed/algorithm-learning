package com.sean.刷题.动态规划;

/**
 * _72_编辑距离
 * 给你两个单词  word1 和  word2，请你计算出将  word1  转换成  word2 所使用的最少操作数  。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * 链接：https://leetcode-cn.com/problems/edit-distance
 *
 * @author chenxu
 * @summary _72_编辑距离
 * @since 2020-08-12 13:01
 */
public class _72_编辑距离 {

    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return 0;

        char[] cs1 = word1.toCharArray();
        char[] cs2 = word2.toCharArray();

        int[][] dp = new int[cs1.length + 1][cs2.length + 1];
        dp[0][0] = 0;

        // 第0列
        for (int i = 1; i <= cs1.length; i++) {
            dp[i][0] = i;
        }

        // 第0行
        for (int j = 1; j <= cs2.length; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= cs1.length; i++) {
            for (int j = 1; j <= cs2.length; j++) {
                int top = dp[i - 1][j] + 1;
                int left = dp[i][j - 1] + 1;
                int leftTop = dp[i - 1][j - 1];
                if (cs1[i - 1] != cs2[j - 1]) {
                    leftTop++;
                }
                dp[i][j] = Math.min(Math.min(top, left), leftTop);

            }
        }
        return dp[cs1.length][cs2.length];

    }
}
