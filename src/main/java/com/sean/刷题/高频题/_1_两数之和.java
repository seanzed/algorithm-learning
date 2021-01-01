package com.sean.刷题.高频题;

import java.util.HashMap;
import java.util.Map;

/**
 * _1_两数之和
 * 给定一个整数数组 nums  和一个目标值 target，请你在该数组中找出和为目标值的那  两个  整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *   
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 *
 * 链接：https://leetcode-cn.com/problems/two-sum
 *
 * @author chenxu
 * @summary _1_两数之和
 * @since 2020-11-19 20:31
 */
public class _1_两数之和 {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null) return null;

        // 用来存放之前扫描过的元素
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer idx = map.get(target - nums[i]);
            if (idx != null) return new int[] {idx, i};
            map.put(nums[i], i);
        }
        return null;
    }
}
