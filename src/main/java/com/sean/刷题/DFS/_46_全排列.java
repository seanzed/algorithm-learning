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
public class _46_全排列 {

    /**
     * 返回结果
     */
    private List<List<Integer>> list;

    private int[] nums;

    /**
     * 用来保存每一层的选择结果
     */
    private int[] result;

    /**
     * 用来标记nums中的数字是否已经被使用过了
     */
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) return null;
        list = new ArrayList<>();
        if (nums.length == 0) return list;
        this.nums = nums;
        result = new int[nums.length];
        used = new boolean[nums.length];
        dfs(0);
        return list;
    }

    private void  dfs(int idx) {
        // 不能再往下搜索
        if (idx == nums.length) {
            List<Integer> resultList = new ArrayList<>();
            for (int value : result) {
                resultList.add(value);
            }
            list.add(resultList);
            return;
        }

        // 枚举这一层所有可以做的选择
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            result[idx] = nums[i];
            // 标记当前数字已经被使用过了
            used[i] = true;

            dfs(idx + 1);

            // 还原现场
            used[i] = false;
        }
    }
}
