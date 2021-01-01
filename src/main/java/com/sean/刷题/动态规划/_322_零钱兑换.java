package com.sean.刷题.动态规划;

/**
 * _322_零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回  -1。
 *
 *
 *
 * 示例  1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *
 * 链接：https://leetcode-cn.com/problems/coin-change
 *
 * @author chenxu
 * @summary _322_零钱兑换
 * @since 2020-08-15 17:17
 */
public class _322_零钱兑换 {

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) return -1;

        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                // 如果当前金额小于当前面值
                if (i < coin) continue;

                int v = dp[i - coin];
                if (v < 0 || v >= min) continue;
                min = v;
            }

            if (min == Integer.MAX_VALUE) {
                dp[i] = -1;
            } else {
                dp[i] = min + 1;
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        _322_零钱兑换 test = new _322_零钱兑换();
        int[] coins = new int[] {1, 2, 5};
        int amount = 13;
        System.out.println(test.coinChange(coins, amount));
    }
}
