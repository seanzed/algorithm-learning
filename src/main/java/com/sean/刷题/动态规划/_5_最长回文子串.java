package com.sean.刷题.动态规划;

/**
 * _5_最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @author chenxu
 * @summary _5_最长回文子串
 * @since 2020-08-12 00:24
 */
public class _5_最长回文子串 {

    public static void main(String[] args) {
        _5_最长回文子串 test = new _5_最长回文子串();
        System.out.println(longestPalindromeDp("sabbasd"));
         System.out.println(test.longestPalindromeEx("sabbasd"));
    }

    public static String longestPalindromeEx2(String s) {
        if (s == null && s.length() == 0) return null;
        char[] cs = s.toCharArray();

        // 最长回文子串的长度(至少是1)
        int maxLen = 1;
        // 最长回文子串的开始索引
        int begin = 0;
        int i= 0;
        while (i < cs.length) {
            int l = i - 1;
            // 找到右边第一个不等于cs[i]的位置
            int r = i;
            while (++r < cs.length && cs[r] == cs[i]);
            // r会成为新的i
            i = r;

            // 从l向左，从r向右扩展
            while (l >= 0 && r < cs.length && cs[l] == cs[r]) {
                l--;
                r++;
            }

            // 扩展结束后，cs[l + 1, r)就是刚才找到的最大回文子串
            // ++l后，l就是刚才找到的最大回文子串的开始索引
            int len = r - ++l;
            if (len > maxLen) {
                maxLen = len;
                begin = l;
            }
        }
        return new String(cs, begin, maxLen);
    }

    /**
     * 拓展重心法
     *
     * @param   s
     * @return  {@link String}
     * @summary 拓展重心法
     * @author chenxu
     * @version v1
     * @since 2020-08-12 12:49:54
     */
    public String longestPalindromeEx(String s) {
        if (s == null || s.length() == 0) return null;
        char[] cs= s.toCharArray();
        // 最长回文子串的长度(至少是1)
        int maxLen = 1;
        // 最长回文子串的开始索引
        int begin = 0;

        for (int i = cs.length - 2; i >= 1; i--) {
            // 字符为中心向左右拓展
            int len1 = palindromeLength(cs,  i - 1, i + 1);
            // 以字符又变的间隙为中心向左右拓展
            int len2 = palindromeLength(cs, i , i + 1);
            len1 = Math.max(len1, len2);
            if (len1 > maxLen) {
                maxLen = len1;
                begin = i - ((maxLen - 1) >> 1);
            }
        }
        // 以0号字符右边的间隙为中心的最长回文子串长度是2
        if (cs[0] == cs[1] && maxLen < 2) {
            // cs[0, 1]就是最长的回文子串
            begin = 0;
            maxLen = 2;
        }
        return new String(cs, begin, maxLen);
    }

    /**
     * 从l开始向左、从r开始向右扫描，获得的最长回文子串的长度
     */
    private int palindromeLength(char[] cs, int l, int r) {
        while (l >= 0 && r < cs.length && cs[l] == cs[r]) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    /**
     * 动态规划版本
     */
    public static String longestPalindromeDp(String s) {
        if (s == null || s.length() == 0) return null;

        char[] cs = s.toCharArray();
        // 最长回文子串的长度
        int maxLen = 0;
        // 最长回文子串的开始索引
        int begin = 0;
        boolean[][] dp = new boolean[cs.length][cs.length];
        // 从下到上 （i由大到小）
        for (int i = cs.length - 1; i >= 0; i--) {
            // 从左向右
            for (int j = i; j < cs.length; j++) {
                // cs[i. j]的长度
                int len = j - i + 1;
                dp[i][j] = (cs[i] == cs[j] && (len <= 2 || dp[i + 1][j - 1]));
                if (dp[i][j] && len > maxLen) {
                    maxLen = len;
                    begin = i;
                }
            }
        }
        return new String(cs, begin, maxLen);
    }
}
