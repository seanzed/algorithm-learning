package com.sean.刷题.双指针;

import java.util.Arrays;

/**
 * _977_有序数组的平方
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 *
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 *
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 *
 * @author chenxu
 * @summary _977_有序数组的平方
 * @since 2020-08-30 18:17
 */
public class _977_有序数组的平方 {

    public int[] sortedSquares(int[] A) {
        // 新数组
        int[] nums = new int[A.length];
        for (int left = 0, right = A.length - 1, index = right; left <= right; ) {
            int powLeft = A[left] * A[left];
            int powRight = A[right] * A[right];
            // 从两边开始比较，比较的时候，只动值大的指针
            // 每次都插入值大的进数组
            if (powLeft > powRight) {
                left++;
                nums[index--] = powLeft;
            } else {
                right--;
                nums[index--] = powRight;
            }
        }
        return nums;
    }

    public int[] sortedSquares1(int[] A) {
        int length = A.length;
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            ans[i] = A[i] * A[i];
        }
        Arrays.sort(ans);
        return ans;
    }
}
