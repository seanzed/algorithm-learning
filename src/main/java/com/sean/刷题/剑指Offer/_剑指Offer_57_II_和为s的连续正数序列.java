package com.sean.刷题.剑指Offer;


import java.util.ArrayList;
import java.util.List;

/**
 * _剑指Offer_57_II_和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *  
 *
 * 限制：
 *
 * 1 <= target <= 10^5
 *
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 *
 * @author chenxu
 * @summary _剑指Offer_57_II_和为s的连续正数序列
 * @since 2020-09-05 11:34
 */
public class _剑指Offer_57_II_和为s的连续正数序列 {

    public int[][] findContinuousSequence(int target) {
        int left = 1;
        int right = 1;
        int sum = 0;
        List<int[]> res = new ArrayList<>();

        int mid = target / 2;
        while (left <= mid) {
            if (sum < target) {
                sum += right;
                right++;
            } else if (sum > target) {
                sum -= left;
                left++;
            } else {
                int[] array = new int[right - left];
                for (int i = left; i < right; i++) {
                    array[i - left] = i;
                }
                res.add(array);
                // 左边界移动
                sum -= left;
                left++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        _剑指Offer_57_II_和为s的连续正数序列 test = new _剑指Offer_57_II_和为s的连续正数序列();
        test.findContinuousSequence(9);
    }
}
