package com.sean.刷题.动态规划;

/**
 * _16_按摩师
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 * 注意：本题相对原题稍作改动
 *
 * 链接：https://leetcode-cn.com/problems/the-masseuse-lcci
 *
 * @author chenxu
 * @summary _16_按摩师
 * @since 2020-08-15 09:59
 */
public class _16_按摩师 {

    /**
     * 暴力搜索
     */
    public int massage(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        return massage(nums, nums.length - 1);
    }

    private int massage(int[] nums, int index) {
        if (index < 0) return 0;
        return Math.max(massage(nums, index -1), massage(nums, index - 2) + nums[index]);
    }

    /**
     * 动态规划数组版本
     */
    public int massage1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        _16_按摩师 test = new _16_按摩师();
        int[] nums = new int[] {2,1,4,5,3,1,1,3};
        System.out.println(test.massage(nums));
        System.out.println(test.massage1(nums));
    }
}
