package com.sean.刷题.剑指Offer;

/**
 * _剑指Offer17打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *  
 *
 * 说明：
 *
 * 用返回一个整数列表来代替打印
 * n 为正整数
 *
 * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
 *
 * @author chenxu
 * @summary _剑指Offer17打印从1到最大的n位数
 * @since 2020-09-05 09:53
 */
public class _剑指Offer_17_打印从1到最大的n位数 {

    public int[] printNumbers(int n) {
        int sum = (int)Math.pow(10, n) - 1;
        int[] res = new int[sum];
        for (int i = 0; i <  sum ; i++) {
            res[i] = i + 1;
            System.out.println(i+ 1);
        }
        return res;
    }

    public static void main(String[] args) {
        _剑指Offer_17_打印从1到最大的n位数 test = new _剑指Offer_17_打印从1到最大的n位数();
        test.printNumbers(3);
    }
}
