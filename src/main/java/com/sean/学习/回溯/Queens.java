package com.sean.学习.回溯;

/**
 * Queens
 *
 * @author chenxu
 * @summary Queens
 * @Copyright (c) 2020, Lianjia Group All Rights Reserved.
 * @since 2020-08-07 11:21
 */
public class Queens {

    public static void main(String[] args) {
        new Queens().placeQueues(4);
    }

    /**
     * 数组索引是行号，数组元素是列号
     */
    int[] cols;

    /**
     * 一共有多少种摆法
     */
    int ways;

    void placeQueues(int n) {
        if (n < 1) return;
        cols = new int[n];
        place(0);
        System.out.println(n + "皇后一共有" + ways + "种摆法") ;
    }

    void place(int row) {
        if (row == cols.length) {
            ways++;
            show();
            return;
        }

        for (int col = 0; col < cols.length; col++) {
            if (isValid(row, col)) {
                // 在第row行第col列摆放皇后
                cols[row] = col;
                place(row + 1);
            }
        }
    }

    boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            // 第col列已经有皇后
            if (cols[i] == col) {
                System.out.println("[" + row + "][" + col + "]=false");
                return false;
            }

            // 第i行的皇后跟第row行第col列鸽子处在同一斜线上
            if (row - i == Math.abs(col - cols[i])) {
                System.out.println("[" + row + "][" + col + "]=false");
                return false;
            }
        }
        System.out.println("[" + row + "][" + col + "]=true");
        return true;
    }

    void show() {
        for (int row = 0; row < cols.length; row++) {
            for (int col = 0; col < cols.length; col++) {
                if (cols[row] == col) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
        System.out.println("------------------------------");
    }
}
