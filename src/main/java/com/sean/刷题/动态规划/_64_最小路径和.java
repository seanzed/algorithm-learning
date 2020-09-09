package com.sean.刷题.动态规划;

/**
 * _64_最小路径和 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入: [   [1,3,1], [1,5,1], [4,2,1] ] 输出: 7 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 *
 * @author chenxu
 * @summary _64_最小路径和
 * @since 2020-08-24 00:03
 */
public class _64_最小路径和 {

    public int minPathSum(int[][] grid) {
        if (grid == null) return 0;
        int rows = grid.length;
        int cows = grid[0].length;

        int[][] dp = new int[rows][cows];
        dp[0][0] = grid[0][0];

        for (int cow = 1; cow < cows; cow++) {
            dp[0][cow] = dp[0][cow - 1] + grid[0][cow];
        }

        for (int row = 1; row < rows; row++) {
            dp[row][0] = dp[row - 1][0] + grid[row][0];
        }

        for (int row = 1; row < rows; row++) {
            for (int cow = 1; cow < cows; cow++) {
                dp[row][cow] = Math.min(dp[row - 1][cow], dp[row][cow - 1]) + grid[row][cow];
            }
        }
        return dp[rows - 1][cows - 1];
    }

    public static void main(String[] args) {
        _64_最小路径和 test = new _64_最小路径和();

        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        System.out.println(test.minPathSum(null));
    }
}
