package com.sean.刷题.动态规划;

/**
 * _08_01_三步问题
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 *
 * 链接：https://leetcode-cn.com/problems/three-steps-problem-lcci
 *
 * @author chenxu
 * @summary _08_01_三步问题
 * @since 2020-08-15 11:40
 */
public class _08_01_三步问题 {

    public int waysToStep(int n) {
        final int mod = 1000000007;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;

        long first = 1;
        long second = 2;
        long third = 4;
        for (int i = 4; i <= n; i++) {
            long tmp = (first + second + third) %mod;
            first = second;
            second = third;
            third = tmp;

        }
        return (int)third;
    }

    public int waysToStep1(int n) {
        final int mod = 1000000007;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;

        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) %mod;
        }
        return (int)dp[n];
    }

    public static void main(String[] args) {
        _08_01_三步问题 test = new _08_01_三步问题();
        System.out.println(test.waysToStep(1000000));
        System.out.println(test.waysToStep1(1000000));
    }
}
