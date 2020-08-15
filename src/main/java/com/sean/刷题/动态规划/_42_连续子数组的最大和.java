package com.sean.刷题.动态规划;

/**
 * _42_连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 *
 * 要求时间复杂度为O(n)。
 *
 * @author chenxu
 * @summary _42_连续子数组的最大和
 * @since 2020-08-15 00:15
 */
public class _42_连续子数组的最大和 {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int dp = nums[0];
        int max = dp;
        for (int i = 1; i < nums.length; i++) {
            if (dp > 0) {
                dp = dp + nums[i];
            } else {
                dp = nums[i];
            }
            max = Math.max(max, dp);
        }
        return max;
    }
}
