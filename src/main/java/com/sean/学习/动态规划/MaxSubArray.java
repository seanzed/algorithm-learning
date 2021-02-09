package com.sean.学习.动态规划;

/**
 * 最大连续子串
 *
 * @author chenxu
 * @summary 最大连续子串
 * @since 2020-08-10 12:33
 */
public class MaxSubArray {

    public static void main(String[] args) {
        System.out.println(maxSubArray2(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }

    /**
     * 最大连续子串动态规划版本---优化版
     *  空间复杂度O(1), 时间复杂度O(n)
     * @param   nums
     * @return  {@link int}
     * @summary
     * @author chenxu
     * @version v1
     * @since 2020-08-10 12:37:53
     */
    static int maxSubArray2(int[] nums) {
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

    /**
     * 最大连续子串动态规划版本---未优化版
     *  空间复杂度O(n), 时间复杂度O(n)
     * @param   nums
     * @return  {@link int}
     * @summary
     * @author chenxu
     * @version v1
     * @since 2020-08-10 12:37:53
     */
    int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int max = dp[0] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            int prev = dp[i - 1];
            if (prev > 0) {
                dp[i] = prev + nums[i];
            } else {
                dp[i] = nums[i];
            }

            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
