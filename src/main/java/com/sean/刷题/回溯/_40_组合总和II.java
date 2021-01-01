package com.sean.刷题.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * _40_组合总和II
 * 
 * 给定一个数组  candidates  和一个目标数  target  ，找出  candidates  中所有可以使数字和为  target  的组合。
 *
 * candidates  中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。  
 * 示例  1:
 *
 * 输入: candidates =  [10,1,2,7,6,1,5], target =  8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例  2:
 *
 * 输入: candidates =  [2,5,2,1,2], target =  5,
 * 所求解集为:
 * [
 *    [1,2,2],
 *    [5]
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 *
 * @author chenxu
 * @summary _40_组合总和II
 * @since 2020-12-31 17:52
 */
public class _40_组合总和II {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null)  return null;

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        dsf(candidates, target, ans, list, 0);
        return ans;
    }

    private void dsf(int[] candidates, int target, List<List<Integer>> ans, List<Integer> list , int idx) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
        }

        int length = candidates.length;
        for (int i = idx; i < length && target - candidates[i] >= 0; i++) {
            list.add(candidates[i]);
            dsf(candidates, target - candidates[i], ans, list, i + 1);
            // 处理相邻数据相同的情况
            while (i < length - 1 && candidates[i] == candidates[i + 1]) {
                i++;
            }
            list.remove(list.size() - 1);
        }
    }


}
