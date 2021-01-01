package com.sean.刷题.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * _46_全排列
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/permutations
 *
 * @author chenxu
 * @summary _46_全排列
 * @since 2020-12-31 17:33
 */
public class _46_全排列 {

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) return null;
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) return result;
        dsf(0, nums, result);
        return result;
    }

    private void dsf(int index, int[] nums, List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
        }

        // 枚举这一层所有的可能
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            dsf(index + 1, nums, result);
            // 回溯
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
