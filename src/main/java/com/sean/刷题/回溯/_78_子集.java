package com.sean.刷题.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * _78_子集
 *
 * 给你一个整数数组 nums ，返回该数组所有可能的子集（幂集）。解集不能包含重复的子集。
 *
 *  
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 *
 * 链接：https://leetcode-cn.com/problems/subsets
 *
 * @author chenxu
 * @summary _78_子集
 * @since 2020-12-31 18:22
 */
public class _78_子集 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dsf(nums, ans, list, 0);
        return ans;
    }

    private void dsf(int[] nums, List<List<Integer>> ans, List<Integer> list, int idx) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        // 选取当前数组
        list.add(nums[idx]);
        dsf(nums, ans, list, idx + 1);
        list.remove(list.size() - 1);
        // 不选取当前数组
        dsf(nums, ans, list, idx + 1);
    }
}
