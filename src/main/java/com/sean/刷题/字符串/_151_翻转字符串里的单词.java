package com.sean.刷题.字符串;

/**
 * _151_翻转字符串里的单词 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 说明：
 *
 * 无空格字符构成一个 单词 。 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。  
 *
 * 示例 1：
 *
 * 输入："the sky is blue" 输出："blue is sky the" 示例 2：
 *
 * 输入："  hello world!  " 输出："world! hello" 解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 示例 3：
 *
 * 输入："a good   example" 输出："example good a" 解释：如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。 示例 4：
 *
 * 输入：s = "  Bob    Loves  Alice   " 输出："Alice Loves Bob" 示例 5：
 *
 * 输入：s = "Alice does not even like bob" 输出："bob like even not does Alice"  
 *
 * 提示：
 *
 * 1 <= s.length <= 104 s 包含英文大小写字母、数字和空格 ' ' s 中 至少存在一个 单词  
 *
 * 进阶：
 *
 * 请尝试使用 O(1) 额外空间复杂度的原地解法。
 *
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 *
 * @author chenxu
 * @summary _151_翻转字符串里的单词
 * @since 2020-11-16 14:18
 */
public class _151_翻转字符串里的单词 {

    public String reverseWords1(String s) {
        // 删除首尾空格
        s = s.trim();
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            // 搜索首个空格
            while (i >= 0 && s.charAt(i) != ' ') i--;
            // 添加单词
            res.append(s.substring(i + 1, j + 1) + " ");
            // 跳过单词间空格
            while (i >= 0 && s.charAt(i) == ' ') i--;
            // j 指向下个单词的尾字符
            j = i;
        }
        // 转化为字符串并返回
        return res.toString().trim();
    }

    public static String reverseWords(String s) {
        if (s == null) return "";

        char[] chars = s.toCharArray();
        // 消除多余的空格
        // 字符串最终有效长度
        int len = 0;
        // 当前用来存放字符的位置
        int cur = 0;
        // 前一个字符是否为空格字符
        boolean space = true;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                // chars[i]是非空字符
                chars[cur++] = chars[i];
                space = false;
            } else if (space == false) {
                // chars[i] 是空字符，chars[i-1]是非空字符
                chars[cur++] = ' ';
                space = true;
            }
        }

        // 对整一个有效字符串进行逆序
        len = space ? (cur - 1) : cur;
        if (len <= 0) return "";

        // 对每一个单词进行逆序
        // 前一个空格字符位置（有-1位置有个假想的哨兵，就是一个假想的空格字符）
        int prevSpaceIdx = -1;
        for (int i = 0; i < len; i++) {
            if (chars[i] != ' ') continue;
            // i是空格字符的位置
            reverse(chars, prevSpaceIdx + 1, i);
            prevSpaceIdx = i;
        }

        // 翻转最后一个单词
        reverse(chars, prevSpaceIdx + 1, len);

        return new String(chars, 0, len);
    }

    /**
     * 将[li, ri)范围内的字符串进行逆序
     */
    private static void reverse(char[] chars, int li, int ri) {
        ri--;
        while (li < ri) {
            char tmp = chars[li];
            chars[li] = chars[ri];
            chars[ri] = tmp;
            li++;
            ri--;
        }
    }

    public static void main(String[] args) {
        System.out.println("666_" + reverseWords("") + "_666");
        System.out.println("666_" + reverseWords("  hello world!     ") + "_666");
        System.out.println("666_" + reverseWords("a good   example") + "_666");
        System.out.println("666_" + reverseWords("are you ok") + "_666");
    }
}
