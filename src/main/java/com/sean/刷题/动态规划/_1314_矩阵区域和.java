package com.sean.刷题.动态规划;

/**
 * _1314_矩阵区域和
 * 给你一个  m * n  的矩阵  mat  和一个整数  K ，请你返回一个矩阵  answer  ，其中每个  answer[i][j]  是所有满足下述条件的元素  mat[r][c] 的和：
 *
 * i - K <= r <= i + K, j - K <= c <= j + K
 * (r, c)  在矩阵内。
 *
 *
 * 示例 1：
 *
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
 * 输出：[[12,21,16],[27,45,33],[24,39,28]]
 * 示例 2：
 *
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
 * 输出：[[45,45,45],[45,45,45],[45,45,45]]
 *
 *
 * 提示：
 *
 * m ==  mat.length
 * n ==  mat[i].length
 * 1 <= m, n, K <= 100
 * 1 <= mat[i][j] <= 100
 *
 * 链接：https://leetcode-cn.com/problems/matrix-block-sum
 *
 * @author chenxu
 * @summary _1314_矩阵区域和
 * @since 2020-08-15 12:20
 */
public class _1314_矩阵区域和 {

    public int[][] matrixBlockSum(int[][] mat, int K) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] res = new int[row][col];
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++)
                dp[i][j] = mat[i - 1][j - 1] + dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1];
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                int x0 = Math.max(i - K - 1, 0);
                int x1 = Math.min(i + K, row);
                int y0 = Math.max(j - K - 1, 0);
                int y1 = Math.min(j + K, col);
                res[i - 1][j - 1] = dp[x1][y1] - dp[x1][y0] - dp[x0][y1] + dp[x0][y0];
            }
        }
        return res;
    }

}
