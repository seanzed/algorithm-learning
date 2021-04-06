package com.sean.刷题.面试题;

import java.util.Deque;
import java.util.LinkedList;

/**
 * _面试题_01_02_判定是否互为字符重排
 *
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 示例 1：
 *
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 *
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 *
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 *
 * 链接：https://leetcode-cn.com/problems/check-permutation-lcci
 *
 * @author chenxu
 * @summary _面试题_01_02_判定是否互为字符重排
 * @since 2021-03-25 17:16
 */
public class _面试题_01_02_判定是否互为字符重排 {

    public boolean CheckPermutation(String s1, String s2) {
        int length1 = s1.length(), length2 = s2.length();

        if (length1 != length2) {
            return false;
        }

        char[] array = new char[128];
        for (int i = 0; i < length1; i++) {
            array[s1.charAt(i)]++;
            array[s2.charAt(i)]--;
        }

        for (int x : array) {
            if (x != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean CheckPermutation2(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int sum1 = 0;
        int sum2 = 0;
        int mul1 = 1;
        int mul2 = 1;
        for (int i = 0; i < s1.length(); i++) {
            sum1 += s1.charAt(i);
            sum2 += s2.charAt(i);
            mul1 *= s1.charAt(i);
            mul2 *= s2.charAt(i);
        }
        if (sum1 == sum2 && mul1 == mul2) return true;
        return false;
    }

    public static void main(String[] args) {
        _面试题_01_02_判定是否互为字符重排 test = new _面试题_01_02_判定是否互为字符重排();
//        String test1 = "abc";
//        String test2 = "bca";
//        boolean resut1 = test.CheckPermutation(test1, test2);
//        System.out.println("判断结果:" + resut1);

        String test3 = "abb";
        String test4 = "aab";
        boolean resut2 = test.CheckPermutation(test3, test4);
        System.out.println("判断结果:" + resut2);
    }
}
