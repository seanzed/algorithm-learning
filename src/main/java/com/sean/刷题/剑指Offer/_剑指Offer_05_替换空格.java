package com.sean.刷题.剑指Offer;

/**
 * _剑指Offer_05_替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *  
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 10000
 *
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 *
 * @author chenxu
 * @summary _剑指Offer_05_替换空格
 * @since 2020-09-05 10:06
 */
public class _剑指Offer_05_替换空格 {

    public String replaceSpace(String s) {
        int length = s.length();

        char[] array = new char[length * 3];
        int size = 0;

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }

        String newStr = new String(array, 0, size);
        return newStr;
    }

    public String replaceSpace1(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (c == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public String replaceSpace2(String s) {
        return s.replaceAll(" ", "%20");
    }
}
