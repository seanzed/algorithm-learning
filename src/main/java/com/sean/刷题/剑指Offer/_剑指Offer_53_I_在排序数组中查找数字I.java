package com.sean.刷题.剑指Offer;

/**
 * _剑指Offer_53_I_在排序数组中查找数字I 统计一个数字在排序数组中出现的次数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8 输出: 2 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6 输出: 0  
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 *
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 *
 * @author chenxu
 * @summary _剑指Offer_53_I_在排序数组中查找数字I
 * @since 2020-09-10 09:05
 */
public class _剑指Offer_53_I_在排序数组中查找数字I {

    public int search(int[] nums, int target) {
        // 搜索右边界 right
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= target) i = m + 1;
            else j = m - 1;
        }
        int right = i;
        // 若数组中无 target ，则提前返回
        if (j >= 0 && nums[j] != target) return 0;
        // 搜索左边界 right
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] < target) i = m + 1;
            else j = m - 1;
        }
        int left = j;
        return right - left - 1;
    }
}
