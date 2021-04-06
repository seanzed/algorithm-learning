package com.sean.刷题.面试题;

/**
 * _面试题_01_01_判定字符是否唯一
 *
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 *
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 *
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分。
 *
 *
 * 链接：https://leetcode-cn.com/problems/is-unique-lcci
 *
 * @author chenxu
 * @summary _面试题_01_01_判定字符是否唯一
 * @since 2021-03-25 17:05
 */
public class _面试题_01_01_判定字符是否唯一 {

    public boolean isUnique(String astr) {
        int[] arr = new int[128];

        for (int i = 0; i < astr.length(); i++) {
            if (arr[astr.charAt(i)] != 0) {
                return false;
            }
            arr[astr.charAt(i)]++;
        }
        return true;
    }

    public boolean isUnique2(String astr) {
        long bits = 0;
        int size = astr.length();
        for (int i = 0; i < size; i++) {
            int move = astr.charAt(i) - 'A';
            if ((bits & (1L << move)) != 0) {
                //有重复的，直接返回false
                return false;
            } else {
                //标记当前位置有这个字符
                bits |= (1L << move);
            }
        }
        return true;
    }

    public boolean isUnique3(String astr) {
        int size = astr.length();
        for (int i = 0; i < size; i++) {
            int c = astr.charAt(i);
            if (astr.indexOf(c, i + 1) != -1) {
                //有重复的，直接返回false
                return false;
            }
        }
        return true;
    }
}
