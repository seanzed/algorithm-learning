package com.sean.刷题.回溯;

/**
 * _52_N皇后II
 *
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：n = 4
 * 输出：2
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= n <= 9
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 *
 * 链接：https://leetcode-cn.com/problems/n-queens-ii
 *
 * @author chenxu
 * @summary _52_N皇后II
 * @since 2021-02-09 11:26
 */
public class _52_N皇后II {

    private int res = 0;

    public int totalNQueens(int n) {
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j =  0; j < n; j++) {
                chess[i][j] = '.';
            }
        }
        dfs(chess, 0);

        return res;
    }

    private void dfs(char[][] chess, int row) {
        if (row == chess.length) {
            res++;
            return;
        }

        for (int col = 0; col < chess.length; col++) {
            if (valid(chess, row, col)) {
                chess[row][col] = 'Q';
                dfs(chess, row + 1);
                chess[row][col] = '.';
            }
        }
    }

    private boolean valid(char[][] chess, int row, int col) {
        // 当前列已经有皇后
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }

        // 右上角已经有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }

        //判断当前坐标的左上角有没有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _52_N皇后II test = new _52_N皇后II();
        int count = test.totalNQueens(8);
        System.out.println(count);
    }
}