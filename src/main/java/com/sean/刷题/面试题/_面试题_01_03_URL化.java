package com.sean.刷题.面试题;

/**
 * _面试题_01_03_URL化
 *
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 *
 *  
 *
 * 示例 1：
 *
 * 输入："Mr John Smith    ", 13
 * 输出："Mr%20John%20Smith"
 * 示例 2：
 *
 * 输入："               ", 5
 * 输出："%20%20%20%20%20"
 *  
 *
 * 提示：
 *
 * 字符串长度在 [0, 500000] 范围内。
 *
 * 链接：https://leetcode-cn.com/problems/string-to-url-lcci
 *
 * @author chenxu
 * @summary _面试题_01_03_URL化
 * @since 2021-03-25 17:51
 */
public class _面试题_01_03_URL化 {

    public String replaceSpaces(String S, int length) {
        char[] ch = new char[length * 3];
        int index = 0;
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            if (c == ' ') {
                ch[index++] = '%';
                ch[index++] = '2';
                ch[index++] = '0';
            } else {
                ch[index] = c;
                index++;
            }
        }
        return new String(ch, 0, index);
    }
}
