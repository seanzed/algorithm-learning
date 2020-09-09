package com.sean.刷题.动态规划;

import java.util.List;

/**
 * _120_三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 *  
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 *  
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 * 链接：https://leetcode-cn.com/problems/triangle
 *
 * @author chenxu
 * @summary _120_三角形最小路径和
 * @since 2020-08-24 00:19
 */
public class _120_三角形最小路径和 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] dp = new int[size][size];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < size; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j] + triangle.get(i).get(j));
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }

        int minTotal = dp[size - 1][0];
        for (int i = 1; i < size; ++i) {
            minTotal = Math.min(minTotal, dp[size - 1][i]);
        }
        return minTotal;
    }

    public int minimumTotal1(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] dp = new int[size];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < size; i++) {
            dp[i] = dp[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; j--) {
                dp[j] = Math.min(dp[j - 1], dp[j] + triangle.get(i).get(j));
            }
            dp[0] = triangle.get(i).get(0);
        }

        int minTotal = dp[0];
        for (int i = 1; i < size; i++) {
            minTotal = Math.min(minTotal, dp[i]);
        }
        return minTotal;
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
