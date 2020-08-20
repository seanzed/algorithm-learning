package com.sean.学习.串;

/**
 * 蛮力解法2
 *
 * @author chenxu
 * @summary 蛮力解法2
 * @since 2020-08-14 19:26
 */
public class BruteForce02 {

    public static int index(String text, String pattern) {
        if (text == null || pattern == null) return -1;
        char[] textChars = text.toCharArray();
        int tlen = textChars.length;
        if (tlen == 0) return -1;
        char[] patternChars = pattern.toCharArray();
        int plen = patternChars.length;
        if (plen == 0) return -1;
        if (tlen < plen) return -1;

        int tiMax = tlen - plen;
        for (int ti = 0; ti <= tiMax; ti++) {
            int pi = 0;
            for (; pi < plen; pi++) {
                if (textChars[ti + pi] != patternChars[pi]) break;
            }
            if (pi == plen) return ti;
        }
        return -1;
    }
}
