package com.sean.学习.动态规划;

/**
 * 0 - 1背包问题
 *
 * @author chenxu
 * @summary 0 - 1背包问题
 * @since 2020-08-10 19:54
 */
public class Knapsack {

    public static void main(String[] args) {
        int[] values = {6, 3, 5, 4, 6};
        int[] weights = {2, 2, 6, 5, 4};
        int capacity = 10;
        System.out.println(maxValueExactly(values, weights, capacity));
        System.out.println(maxValue(values, weights, capacity));
        System.out.println(maxValue1(values, weights, capacity));
        System.out.println(maxValue2(values, weights, capacity));
    }

    static int maxValueExactly(int[] values, int[] weights, int capacity) {
        if (values == null || values.length == 0) return 0;
        if (weights == null || weights.length == 0) return 0;
        if (values.length != weights.length || capacity <= 0) return 0;
        int[] dp = new int[capacity + 1];
        for (int j = 1; j <= capacity; j++) {
            dp[j] = Integer.MIN_VALUE;
        }

        for (int i = 1; i <= values.length; i++) {
            for (int j = capacity; j >= weights[i - 1]; j--) {
                dp[j] = Math.max(dp[j], values[i - 1] + dp[j - weights[i - 1]]);
            }
        }
        return dp[capacity] < 0 ? -1 : dp[capacity];
    }

    static int maxValue(int[] values, int[] weights, int capacity) {
        if (values == null || values.length == 0) return 0;
        if (weights == null || weights.length == 0) return 0;
        if (values.length != weights.length || capacity <= 0) return 0;

        int[] dp = new int[capacity + 1];
        for (int i = 1; i <= values.length; i++) {
            for (int j = capacity; j >= weights[i - 1]; j--) {
                dp[j] = Math.max(dp[j], values[i - 1] + dp[j - weights[i - 1]]);
            }
        }
        return dp[capacity];
    }

    static int maxValue2(int[] values, int[] weights, int capacity) {
        if (values == null || values.length == 0) return 0;
        if (weights == null || weights.length == 0) return 0;
        if (values.length != weights.length || capacity <= 0) return 0;

        int[] dp = new int[capacity + 1];
        for(int i = 1; i <= values.length; i++) {
            for (int j = capacity; j >= 1; j--) {
                if (j < weights[i - 1]) continue;
                dp[j] = Math.max(dp[j], values[i - 1] + dp[j - weights[i - 1]]);
            }
        }
        return dp[capacity];
    }

    static int maxValue1(int[] values, int[] weights, int capacity) {
        if (values == null || values.length == 0) return 0;
        if (weights == null || weights.length == 0) return 0;
        if (values.length != weights.length || capacity <= 0) return 0;

        int [][] dp = new  int[values.length + 1][capacity + 1];
        for (int i = 1; i <= values.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                // 如果背包容量小于当前重量
                if (j < weights[i - 1]) {
                    // 就不取当前的物品
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], values[i - 1] + dp[i - 1][j - weights[i - 1]]);
                }
            }
        }

        return dp[values.length][capacity];
    }
}
