package com.sean.刷题.剑指Offer;

/**
 * _剑指Offer_14_II_剪绳子_II 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m -
 * 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: 2 输出: 1 解释: 2 = 1 + 1, 1 × 1 = 1 示例 2:
 *
 * 输入: 10 输出: 36 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36  
 *
 * 提示：
 *
 * 2 <= n <= 1000
 *
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof
 *
 * @author chenxu
 * @summary _剑指Offer_14_II_剪绳子_II
 * @since 2020-12-17 22:50
 */
public class _剑指Offer_14_II_剪绳子_II {

    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j])) % 1000000007;
            }
        }
        return dp[n];
    }

    public int cuttingRope1(int n) {
        if (n < 4) {
            return n - 1;
        } else if (n == 4) {
            return n;
        }
        long res = 1;
        while (n > 4) {
            res *= 3;
            res %= 1000000007;
            n -= 3;
        }
        return (int) (res * n % 1000000007);
    }
}
