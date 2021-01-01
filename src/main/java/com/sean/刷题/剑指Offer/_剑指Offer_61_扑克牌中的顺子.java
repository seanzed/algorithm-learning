package com.sean.刷题.剑指Offer;

import java.util.HashSet;
import java.util.Set;

/**
 * _剑指Offer_61_扑克牌中的顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 *
 *
 * 示例  1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 *
 * 示例  2:
 *
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
 *
 * @author chenxu
 * @summary _剑指Offer_61_扑克牌中的顺子
 * @since 2020-09-10 09:24
 */
public class _剑指Offer_61_扑克牌中的顺子 {

    public boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int min = 14, max = 0;
        for (int num : nums) {
            if (num == 0) continue;
            max = Math.max(max, num);
            min = Math.min(min, num);
            if (repeat.contains(num)) return false;
            repeat.add(num);
        }
        return max - min < 5;
    }
}
