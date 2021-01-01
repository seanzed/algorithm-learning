package com.sean.刷题.高频题;

/**
 * _50_Pow
 * 实现  pow(x, n)  ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例  2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例  3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 <  x  < 100.0
 * n  是 32 位有符号整数，其数值范围是  [−231,  231  − 1] 。
 *
 * 链接：https://leetcode-cn.com/problems/powx-n
 *
 * @author chenxu
 * @summary _50_Pow
 * @since 2020-11-27 15:31
 */
public class _50_Pow {

    public double myPow(double x, int n) {
        long y = (n < 0) ? -((long) n) : n;
        double res = 1.0;
        while (y > 0) {
            if ((y & 1) == 1) {
                // 如果最后一个二进位是1, 就累乘上x
                res *= x;
            }
            x *= x;
            // 舍弃掉最后一个二进制位
            y >>= 1;
        }
        return (n < 0) ? (1 / res) : res;
    }

    public double myPow2(double x, int n) {
        if (n == 0) return 1;
        if (n == -1) return 1 / x;
        double half = myPow2(x, n >> 1);
        half *= half;
        // 是否为奇数
        return ((n & 1) == 1) ? (half * x) : half;
    }
}
