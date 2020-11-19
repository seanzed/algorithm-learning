package com.sean.刷题.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * _46_全排列
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
 * @since 2020-11-19 09:26
 */
public class _46_全排列2 {

    /**
     * 返回结果
     */
    private List<List<Integer>> list;

    private int[] nums;

    /**
     * 用来保存每一层的选择结果
     */
    private List<Integer> result;


    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) return null;
        list = new ArrayList<>();
        if (nums.length == 0) return list;
        this.nums = nums;
        result = new ArrayList<>();
        dfs(0);
        return list;
    }

    private void  dfs(int idx) {
        // 不能再往下搜索
        if (idx == nums.length) {
            list.add(new ArrayList<>(result));
            return;
        }

        // 枚举这一层所有可以做的选择
        for (int i = 0; i < nums.length; i++) {
            if (result.contains(nums)) continue;
            result.add(nums[i]);

            dfs(idx + 1);

            result.remove(result.size() - 1);
        }
    }
}
