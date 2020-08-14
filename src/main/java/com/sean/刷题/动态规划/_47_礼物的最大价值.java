package com.sean.刷题.动态规划;

/**
 * _47_礼物的最大价值
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，
 * 并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 *
 *
 * 示例 1:
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *
 * @author chenxu
 * @summary _47_礼物的最大价值
 * @since 2020-08-11 21:18
 */
public class _47_礼物的最大价值 {

    public int maxValue(int[][] grid) {
        if (grid == null) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[2][cols];
        dp[0][0] = grid[0][0];

        // 第0行
        for (int col = 1; col < cols; col++) {
            dp[0][col] = dp[0][col - 1] + grid[0][col];
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (col == 0) {
                    dp[row & 1][col] = dp[(row - 1) & 1][col] + grid[row][col];
                    continue;
                }
                dp[row & 1][col] = Math.max(dp[(row - 1) & 1][col], dp[row & 1][col - 1]) + grid[row][col];
            }
        }
        return dp[(rows - 1) & 1][cols - 1];
    }

    public int maxValue1(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];

        // 第0行
        for (int col = 1; col < cols; col++) {
            dp[0][col] = dp[0][col - 1] + grid[0][col];
        }
        // 第0列
        for (int row = 1; row < rows; row++) {
            dp[row][0] = dp[row - 1][0] + grid[row][0];
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]) + grid[row][col];
            }
        }
        return dp[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        _47_礼物的最大价值 test = new _47_礼物的最大价值();
        int[][] grid = new int [][] {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        int sum = test.maxValue1(grid);
        System.out.println(sum);

        int[][] grid1 = new int [][] {
                {1, 2},
                {5, 6},
                {1, 1}
        };

//        int[][] grid1 = new int [][] {
//                {0}
//        };

        System.out.println(test.maxValue(grid1));
    }
}
