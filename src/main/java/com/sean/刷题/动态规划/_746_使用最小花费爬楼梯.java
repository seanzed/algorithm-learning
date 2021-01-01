package com.sean.刷题.动态规划;

/**
 * _746_使用最小花费爬楼梯
 * 数组的每个索引作为一个阶梯，第  i个阶梯对应着一个非负数的体力花费值  cost[i](索引从0开始)。
 *
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 *
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 *
 * 示例  1:
 *
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 *   示例 2:
 *
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出: 6
 * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 * 注意：
 *
 * cost  的长度将会在  [2, 1000]。
 * 每一个  cost[i] 将会是一个Integer类型，范围为  [0, 999]。
 *
 * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
 *
 * @author chenxu
 * @summary _746_使用最小花费爬楼梯
 * @Copyright (c) 2020, Lianjia Group All Rights Reserved.
 * @since 2020-08-15 10:49
 */
public class _746_使用最小花费爬楼梯 {

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = 0;
        dp[1] = Math.min(cost[0], cost[1]);

        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i], dp[i - 2] + cost[i - 1]);
        }
        return dp[cost.length - 1];
    }

    public int minCostClimbingStairs1(int[] cost) {
        int minFirst = 0;
        int minSecond = Math.min(cost[0], cost[1]);
        int minCost = 0;
        for (int i = 2; i < cost.length; i++) {
            minCost = Math.min(minSecond + cost[i], minFirst + cost[i - 1]);
            minFirst = minSecond;
            minSecond = minCost;
        }
        return minCost;
    }

    public int minCostClimbingStairs2(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] = Math.min(cost[i - 2], cost[i - 1]) + cost[i];
        }
        return Math.min(cost[cost.length - 2], cost[cost.length - 1]);
    }

    public static void main(String[] args) {
        _746_使用最小花费爬楼梯 test = new _746_使用最小花费爬楼梯();
        int[] costs = new int[] {0, 1, 1, 0};
        System.out.println(test.minCostClimbingStairs2(costs));
        System.out.println(test.minCostClimbingStairs1(costs));
        System.out.println(test.minCostClimbingStairs(costs));
    }
}
