package com.sean.刷题.动态规划;

/**
 * _53_最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * @author chenxu
 * @summary _53_最大子序和
 * @Copyright (c) 2020, Lianjia Group All Rights Reserved.
 * @since 2020-08-15 09:38
 */
public class _53_最大子序和 {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return maxSubArray(nums, 0, nums.length);
    }

    private static int maxSubArray(int[] nums, int begin, int end) {
        if ((end - begin) < 2)return nums[begin];
        int mid =  (end + begin) >> 1;

        int leftMax = nums[mid - 1];
        int leftSum = leftMax;
        for (int i = mid - 2; i >= begin; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax, leftSum);
        }

        int rightMax = nums[mid];
        int rightSum = rightMax;
        for (int j = mid + 1; j < end; j++) {
            rightSum += nums[j];
            rightMax = Math.max(rightMax, rightSum);
        }

        return Math.max(leftMax + rightMax, Math.max(maxSubArray(nums, begin, mid), maxSubArray(nums, mid, end)));
    }

    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int dp = nums[0];
        int max = dp;

        for (int i = 1; i < nums.length; i++) {
            if (dp > 0) {
                dp += nums[i];
            } else {
                dp = nums[i];
            }
            max = Math.max(max, dp);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        _53_最大子序和 test = new _53_最大子序和();
        test.maxSubArray(nums);
    }
}
