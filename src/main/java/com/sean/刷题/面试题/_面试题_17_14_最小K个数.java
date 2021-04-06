package com.sean.刷题.面试题;

import java.util.PriorityQueue;

/**
 * _面试题_17_14_最小K个数
 *
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 *
 * 示例：
 *
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * 提示：
 *
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 *
 *
 * 链接：https://leetcode-cn.com/problems/smallest-k-lcci
 *
 * @author chenxu
 * @summary _面试题_17_14_最小K个数
 * @since 2021-03-25 18:53
 */
public class _面试题_17_14_最小K个数 {

    public int[] smallestK(int[] arr, int k) {
        int[] result = new int[k];
        if (k == 0) {
            return result;
        }
        // 构建大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (x1, x2) -> x2 - x1);

        for (int i = 0; i < arr.length; i++) {
            if (queue.size() < k) {
                queue.offer(arr[i]);
            } else {
                if (queue.peek() > arr[i]) {
                    queue.poll();
                    queue.offer(arr[i]);
                }
            }
        }


        int index = k;
        for (int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll();
        }
        return result;
    }

    public int[] smallestK2(int[] arr, int k) {
        int[] result = new int[k];
        if (k == 0) return result;
        sort(arr, 0, arr.length);
        System.arraycopy(arr, 0, result, 0,  k);
        return result;
    }

    private void sort(int[] nums, int begin, int end) {
        if (end - begin < 2) return;
        int mid = pivotIndex(nums, begin, end);
        sort(nums, begin, mid);
        sort(nums, mid + 1, end);
    }

    /**
     * 轴点元素的最终位置
     * 构造出 [begin, end) 范围的轴点元素
     * @param   nums
     * @param   begin
     * @param   end
     * @return  {@link int}
     * @summary 轴点元素的最终位置
     * @since 2021-01-26 11:40:42
     */
    private int pivotIndex(int[] nums, int begin, int end) {
        swap(nums, begin, begin + (int) (Math.random() * (end - begin)));
        int pivot = nums[begin];
        end--;
        while (begin < end) {
            while (begin < end) {
                // 右边元素 > 轴点元素
                if (pivot < nums[end]) {
                    end--;
                } else {
                    nums[begin++] = nums[end];
                    break;
                }
            }

            while (begin < end) {
                if (pivot > nums[begin]) {
                    begin++;
                } else {
                    nums[end--] = nums[begin];
                    break;
                }
            }
        }
        // 将轴点元素放入最终的位置
        nums[begin] = pivot;
        // 返回轴点元素的位置
        return begin;
    }

    private void swap(int[] array, int low, int high) {
        int temp = array[low];
        array[low] = array[high];
        array[high] = temp;
    }

    public static void main(String[] args) {
        _面试题_17_14_最小K个数 test = new _面试题_17_14_最小K个数();
        int[] arr =  new int[]{1,3,5,7,2,4,6,8};
        int k = 4;
        int[] result = test.smallestK(arr, k);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
