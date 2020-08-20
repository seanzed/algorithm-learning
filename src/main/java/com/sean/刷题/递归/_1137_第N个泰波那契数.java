package com.sean.刷题.递归;

/**
 * _1137_第N个泰波那契数
 * 泰波那契序列 Tn 定义如下： 
 *
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 *
 * 输入：n = 25
 * 输出：1389537
 *  
 *
 * 提示：
 *
 * 0 <= n <= 37
 * 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。
 *
 * 链接：https://leetcode-cn.com/problems/n-th-tribonacci-number
 *
 * @author chenxu
 * @summary _1137_第N个泰波那契数
 * @since 2020-08-15 18:49
 */
public class _1137_第N个泰波那契数 {

    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;

        int first = 0, second = 1, third = 1;
        for (int i = 3; i <= n; i++) {
            int tmp = third;
            third = first + second + third;
            first = second;
            second = tmp;
        }
        return third;
    }

    public static void main(String[] args) {
        _1137_第N个泰波那契数 test = new _1137_第N个泰波那契数();
        System.out.println(test.tribonacci(25));
    }
}
