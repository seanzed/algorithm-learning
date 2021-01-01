package com.sean.刷题.优先级队列;

import java.util.PriorityQueue;

/**
 * _215_数组中的第K个最大元素
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例  2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 *
 * @author chenxu
 * @summary _215_数组中的第K个最大元素
 * @since 2020-12-28 19:17
 */
public class _215_数组中的第K个最大元素 {

    public int findKthLargest(int[] nums, int k) {
        // 小顶堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(nums[i]);
            } else {
                Integer value = priorityQueue.peek();
                // 如果当前值，大于小顶堆堆顶值，就插入
                if (value < nums[i]) {
                    priorityQueue.remove();
                   priorityQueue.offer(nums[i]);
                }
            }
        }

        return priorityQueue.peek();
    }

    public static void main(String[] args) {

        int[] nums = new int[] {3,2,1,5,6,4};
        int k = 2;
        _215_数组中的第K个最大元素 test = new _215_数组中的第K个最大元素();
        System.out.println(test.findKthLargest(nums, 2));

    }
}
