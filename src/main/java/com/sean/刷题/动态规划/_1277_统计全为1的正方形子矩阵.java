package com.sean.刷题.动态规划;

/**
 * _1277_统计全为1的正方形子矩阵
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 *
 * https://leetcode-cn.com/problems/count-square-submatrices-with-all-ones/
 * @TODO 待学习
 *
 * @author chenxu
 * @summary _1277_统计全为1的正方形子矩阵
 * @since 2020-08-15 12:34
 */
public class _1277_统计全为1的正方形子矩阵 {

    /**
     * 为了统计正方形矩阵的个数，可以假定当前位置ij为正方形的右下角点，其值为可能的最大边长maxlen = matrix[i][j]。
     *
     * 沿着同一列j向上遍历，遍历行数即为当前正方形的边长curlen，当遍历过程的最小边长minlen >= curlen时，可以构成当前正方形。
     *
     */
    public int countSquares(int[][] matrix) {
        int result = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] != 1){
                    continue;
                }
                result++;
                if(j == 0){
                    matrix[i][j] = 1;
                    continue;
                }
                matrix[i][j] = matrix[i][j - 1] + 1;
                if(i == 0){
                    continue;
                }
                int maxlen = matrix[i][j];
                int minlen = maxlen;
                int row = i - 1;
                int curlen = 2;
                while(row >= 0 && curlen <= maxlen){
                    minlen = Math.min(matrix[row][j], minlen);
                    if(minlen < curlen){
                        break;
                    }
                    result++;
                    row--;
                    curlen++;
                }
            }
        }
        return result;
    }

}
