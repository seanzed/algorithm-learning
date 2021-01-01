package com.sean.刷题.剑指Offer;

/**
 * _剑指Offer_53_II_中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 * 示例  2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 *
 * @author chenxu
 * @summary _剑指Offer_53_II_中缺失的数字
 * @since 2020-09-10 22:43
 */
public class _剑指Offer_53_II_中缺失的数字 {

    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right)  >>> 1;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
