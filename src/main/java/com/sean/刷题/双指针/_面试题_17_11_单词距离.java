package com.sean.刷题.双指针;

/**
 * _面试题_17_11_单词距离
 * 有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
 *
 * 示例：
 *
 * 输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
 * 输出：1
 * 提示：
 *
 * words.length <= 100000
 *
 * 链接：https://leetcode-cn.com/problems/find-closest-lcci
 *
 * @author chenxu
 * @summary _面试题_17_11_单词距离
 * @since 2020-08-30 20:51
 */
public class _面试题_17_11_单词距离 {

    public int findClosest(String[] words, String word1, String word2) {
        int min = -1;
        int lastWord1Index = -1;
        int lastWord2Index = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                lastWord1Index = i;
            }

            if (words[i].equals(word2)) {
                lastWord2Index = i;
            }

            if (lastWord1Index == -1 || lastWord2Index == -1) {
                continue;
            }

            int tmp = Math.abs(lastWord1Index - lastWord2Index);
            if (tmp < min || min == -1) {
                min = tmp;
            }

        }
        return min;
    }

    public static void main(String[] args) {
        String[] words = new String[] {
                "I","am","a","student","from","a","university","in","a","city"
        };
        _面试题_17_11_单词距离 test = new _面试题_17_11_单词距离();
        System.out.println(test.findClosest(words, "a", "student"));
    }
}
