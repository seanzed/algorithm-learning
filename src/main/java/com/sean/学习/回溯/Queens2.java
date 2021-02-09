package com.sean.学习.回溯;

/**
 * Queens2
 *
 * @author chenxu
 * @summary Queens2
 * @since 2020-08-07 12:50
 */
public class Queens2 {

    public static void main(String[] args) {
        new Queens2().placeQueeens(8);
    }

    /**
     * 数据索引是行号, 数组元素是行号
     */
    int[] queens;

    /**
     * 标记着某一列是否有皇后
     */
    boolean[] cols;

    /**
     * 标记着某一斜线上是否有皇后(左上角 -> 右下角)
     */
    boolean[] leftTop;

    /**
     * 标记着某一斜线上事发后有皇后(右上角 -> 左下角)
     */
    boolean[] rightTop;

    /**
     * 一共有多少种摆法
     */
    int ways;

    void placeQueeens(int n) {
        if(n < 1) return;
        queens = new int[n];
        cols = new boolean[n];
        leftTop = new boolean[(n<<1) - 1];
        rightTop = new boolean[leftTop.length];
        place(0);
        System.out.println(n + "皇后一共有" + ways + "种摆法");
    }

    void place(int row) {
        if (row == cols.length) {
            ways++;
            show();
            return;
        }

        for (int col = 0; col < cols.length; col++) {
            if (cols[col]) continue;
            int ltIndex = row - col + cols.length - 1;
            if (leftTop[ltIndex]) continue;
            int rtIndex = row + col;
            if (rightTop[rtIndex]) continue;

            queens[row] = col;
            cols[col] = true;
            leftTop[ltIndex] = true;
            rightTop[rtIndex] = true;
            place(row + 1);
            cols[col] = false;
            leftTop[ltIndex] = false;
            rightTop[rtIndex] = false;
        }
    }

    void show() {
        for (int row = 0; row < cols.length; row++) {
            for (int col = 0; col < cols.length; col++) {
                if (queens[row] == col) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
        System.out.println("------------------------------");
    }
}
