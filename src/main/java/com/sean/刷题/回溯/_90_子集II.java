package com.sean.刷题.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * _90_子集II
 *
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 *
 * @author chenxu
 * @summary _90_子集II
 * @since 2020-12-31 18:31
 */
public class _90_子集II {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        dsf(nums, ans, list, 0);
        return ans;
    }

    private void dsf(int[] nums, List<List<Integer>> ans, List<Integer> list, int idx) {
        ans.add(new ArrayList<>(list));

        for (int i = idx; i < nums.length; i++) {

            if (i > idx && nums[i] == nums[i - 1]) {
                continue;
            }

            list.add(nums[i]);
            dsf(nums, ans, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
