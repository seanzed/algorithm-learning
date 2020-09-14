package com.sean.刷题.剑指Offer;

/**
 * _剑指Offer_65_不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * @TODO
 *  
 *
 * 示例:
 *
 * 输入: a = 1, b = 1
 * 输出: 2
 *  
 *
 * 提示：
 *
 * a, b 均可能是负数或 0
 * 结果不会溢出 32 位整数
 *
 * 链接：https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof
 *
 * @author chenxu
 * @summary _剑指Offer_65_不用加减乘除做加法
 * @since 2020-09-09 12:52
 */
public class _剑指Offer_65_不用加减乘除做加法 {

    public int add(int a, int b) {
        // 当进位为 0 时跳出
        while(b != 0) {
            // c = 进位
            int c = (a & b) << 1;
            // a = 非进位和
            a ^= b;
            // b = 进位
            b = c;
        }
        return a;
    }
}
