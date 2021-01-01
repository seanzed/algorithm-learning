package com.sean.刷题.剑指Offer;

/**
 * _剑指Offer_58_II_左旋转字符串
 *
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s = "abcdefg", k = 2
 * 输出:  "cdefgab"
 * 示例 2：
 *
 * 输入: s = "lrloseumgh", k = 6
 * 输出:  "umghlrlose"
 *
 *
 * 限制：
 *
 * 1 <= k < s.length <= 10000
 *
 * 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 *
 * @author chenxu
 * @summary _剑指Offer_58_II_左旋转字符串
 * @since 2020-09-09 12:44
 */
public class _剑指Offer_58_II_左旋转字符串 {

    public String reverseLeftWords(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n; i < s.length() + n; i++) {
            stringBuilder.append(s.charAt(i % s.length()));
        }
        return stringBuilder.toString();
    }

    public String reverseLeftWords1(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}
