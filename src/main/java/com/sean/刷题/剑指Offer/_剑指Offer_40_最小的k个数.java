package com.sean.刷题.剑指Offer;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * _剑指Offer_40_最小的k个数 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2 输出：[1,2] 或者 [2,1] 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1 输出：[0]
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000 0 <= arr[i]  <= 10000
 *
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 *
 * @author chenxu
 * @summary _剑指Offer_40_最小的k个数
 * @since 2020-09-09 09:26
 */
public class _剑指Offer_40_最小的k个数 {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 默认是小根堆，实现大根堆需要重写一下比较器。
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1); // 目的是最大数在第一位
        for (int num : arr) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (pq.peek() > num) {
                pq.poll();
                pq.offer(num);
            }
        }
        // 返回堆中的元素
        int[] res = new int[pq.size()];
        int idx = 0;
        for (int num : pq) {
            res[idx++] = num;
        }
        return res;
    }
}
