package com.sean.刷题.剑指Offer;

/**
 * _剑指Offer_64_求和
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 *
 * 输入: n = 9
 * 输出: 45
 *  
 *
 * 限制：
 *
 * 1 <= n <= 10000
 *
 * 链接：https://leetcode-cn.com/problems/qiu-12n-lcof
 *
 * @author chenxu
 * @summary _剑指Offer_64_求和
 * @since 2020-09-10 22:51
 */
public class _剑指Offer_64_求和 {

    public int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
