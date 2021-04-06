package com.sean.刷题.面试题;

/**
 * _面试题_01_04_回文排列
 *
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 *
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 *
 * 回文串不一定是字典当中的单词。
 *
 *  
 *
 * 示例1：
 *
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 *
 * 链接：https://leetcode-cn.com/problems/palindrome-permutation-lcci
 *
 * @author chenxu
 * @summary _面试题_01_04_回文排列
 * @since 2021-03-25 18:49
 */
public class _面试题_01_04_回文排列 {

    public boolean canPermutePalindrome(String s) {
        int[] map = new int[256];
        int count = 0;
        for (char c : s.toCharArray()) {
            if ((map[c]++ & 1) == 1) {
                count--;
            } else {
                count++;
            }
        }
        return count <= 1;
    }
}
