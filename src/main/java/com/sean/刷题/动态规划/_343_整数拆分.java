package com.sean.刷题.动态规划;

/**
 * _343_整数拆分 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2 输出: 1 解释: 2 = 1 + 1, 1 × 1 = 1。 示例 2:
 *
 * 输入: 10 输出: 36 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 说明: 你可以假设 n 不小于 2 且不大于 58。
 *
 * 链接：https://leetcode-cn.com/problems/integer-break
 *
 * @author chenxu
 * @summary _343_整数拆分
 * @since 2020-08-27 09:12
 */
public class _343_整数拆分 {

    public int integerBreak(int n) {
        if (n < 4) return n - 1;

        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(Math.max(2 * (i - 2), 2 * dp[i - 2]), Math.max(3 * (i - 3), 3 * dp[i - 3]));
        }
        return dp[n];
    }

    public int integerBreak1(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
}
