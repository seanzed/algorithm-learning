package com.sean.刷题.剑指Offer;

/**
 * _剑指Offer_10_II_青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 *
 * 输入：n = 0
 * 输出：1
 * 提示：
 *
 * 0 <= n <= 100
 *
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 *
 * @author chenxu
 * @summary _剑指Offer_10_II_青蛙跳台阶问题
 * @since 2020-12-17 22:19
 */
public class _剑指Offer_10_II_青蛙跳台阶问题 {

    public int numWays(int n) {
        int first = 1, second = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (first + second) % 1000000007;
            first = second;
            second = sum;
        }
        return first;
    }

    public static void main(String[] args) {
        _剑指Offer_10_II_青蛙跳台阶问题 test = new _剑指Offer_10_II_青蛙跳台阶问题();
        System.out.println(test.numWays(7));
    }
}
