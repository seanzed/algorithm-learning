package com.sean.刷题.剑指Offer;

/**
 * _剑指Offer_39_数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 *
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例  1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 50000
 *
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
 *
 * @author chenxu
 * @summary _剑指Offer_39_数组中出现次数超过一半的数字
 * @since 2020-09-05 23:32
 */
public class _剑指Offer_39_数组中出现次数超过一半的数字 {

    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;

        for (int num : nums) {
            if (votes == 0) {
                x = num;
            }

            votes += num == x ? 1 : -1;
        }
        return x;
    }
}
