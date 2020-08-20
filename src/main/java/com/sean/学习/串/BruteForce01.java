package com.sean.学习.串;

/**
 * 蛮力解法1
 *
 * @author chenxu
 * @summary 蛮力解法1
 * @since 2020-08-14 19:26
 */
public class BruteForce01 {

    /**
     * 优化版
     */
    public static int index(String text, String pattern) {
        if (text == null || pattern == null) return -1;
        char[] textChars = text.toCharArray();
        int tlen = textChars.length;
        if (tlen == 0) return -1;
        char[] patternChars = pattern.toCharArray();
        int plen = patternChars.length;
        if (plen == 0) return -1;
        if (tlen < plen) return -1;

        int pi = 0, ti = 0, lenDelta = tlen -plen;
        while (pi < plen && ti -pi <= lenDelta) {
            if (textChars[ti] == patternChars[pi]) {
                ti++;
                pi++;
            } else {
                // 如果不相等 pi置为0, ti减去pi的长度
                ti -= pi -1;
                pi = 0;
            }
        }
        return (pi == plen) ? (ti - pi) : -1;
    }

    /**
     * 最初版
     */
    public static int index1(String text, String pattern) {
        if (text == null || pattern == null) return -1;
        char[] textChars = text.toCharArray();
        int tlen = textChars.length;
        if (tlen == 0) return -1;
        char[] patternChars = pattern.toCharArray();
        int plen = patternChars.length;
        if (plen == 0) return -1;
        if (tlen < plen) return -1;

        int pi = 0, ti = 0;
        while (pi < plen && ti < tlen) {
            if (textChars[ti] == patternChars[pi]) {
                pi++;
                ti++;
            } else {
                ti -= pi - 1;
                pi = 0;
            }
        }
        return (pi == plen) ? (ti - pi) : -1;
    }
}
