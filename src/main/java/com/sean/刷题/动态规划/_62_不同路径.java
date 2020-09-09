package com.sean.刷题.动态规划;

import java.util.Arrays;

/**
 * _62_不同路径 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 *
 *
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 *
 *  
 *
 * 示例 1:
 *
 * 输入: m = 3, n = 2 输出: 3 解释: 从左上角开始，总共有 3 条路径可以到达右下角。 1. 向右 -> 向右 -> 向下 2. 向右 -> 向下 -> 向右 3. 向下 ->
 * 向右 -> 向右 示例 2:
 *
 * 输入: m = 7, n = 3 输出: 28  
 *
 * 提示：
 *
 * 1 <= m, n <= 100 题目数据保证答案小于等于 2 * 10 ^ 9
 *
 * 链接：https://leetcode-cn.com/problems/unique-paths
 *
 * @author chenxu
 * @summary _62_不同路径
 * @since 2020-08-27 08:37
 */
public class _62_不同路径 {

    public int uniquePaths(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }

    /**
     * 动态规划二维数组版---提交超时
     *
     * @return {@link int}
     * @summary
     * @author chenxu
     * @version v1
     * @since 2020-08-27 08:44:47
     */
    public int uniquePaths1(int m, int n) {
        int rows = m;
        int cols = n;
        if (cols < rows) {
            rows = n;
            cols = m;
        }

        int[][] dp = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            dp[row][0] = 1;
        }

        for (int col = 0; col < cols; cols++) {
            dp[0][col] = 1;
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < col; col++) {
                dp[row][col] = dp[row - 1][col] + dp[row][col];
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
