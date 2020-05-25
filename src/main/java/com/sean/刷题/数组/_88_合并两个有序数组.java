package com.sean.刷题.数组;

/**
 * description 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *  
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * https://leetcode-cn.com/problems/merge-sorted-array/
 *
 * @author xchen11 2020/05/25 10:51
 */
public class _88_合并两个有序数组 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] arr = new int[n + m];
        while (j < m || k < n) {
            //注意两个边界条件:j==m，以及k==n，表示一个数组已经拷贝完了
            if (j == m) {
                arr[i++] = nums2[k++];
            } else if (k == n) {
                arr[i++] = nums1[j++];
            } else if (nums1[j] <= nums2[k]) {
                arr[i++] = nums1[j++];
            } else {
                arr[i++] = nums2[k++];
            }
        }
        //还需要将新数组中的元素再拷贝回去
        for (i = 0; i < arr.length; ++i) {
            nums1[i] = arr[i];
        }
    }
}
