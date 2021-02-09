package com.sean.刷题.优先级队列;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * _373_查找和最小的K对数字
 *
 * 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
 *
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
 *
 * 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 *      [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 示例 2:
 *
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 解释: 返回序列中的前 2 对数：
 *      [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * 示例 3:
 *
 * 输入: nums1 = [1,2], nums2 = [3], k = 3
 * 输出: [1,3],[2,3]
 * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
 *
 * 链接：https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums
 *
 * @author chenxu
 * @summary _373_查找和最小的K对数字
 * @since 2021-02-05 16:00
 */
public class _373_查找和最小的K对数字 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        // 小顶堆
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (o1, o2) -> (nums1[o1[0]] + nums2[o1[1]]) - (nums1[o2[0]] + nums2[o2[1]]));
        List<List<Integer>> res = new LinkedList<>();

        // 两个数组有一个为空，返回空
        if(nums1.length==0 || nums2.length == 0){
            return res;
        }

        // 将我们假想的每个数组的第一项加入小顶堆
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            // 加入的是坐标，小顶堆的比较器也是基于坐标比较
            queue.add(new int[] { i, 0 });
        }

        // 循环K次或者堆空
        while (k > 0 && !queue.isEmpty()) {
            // 弹出堆顶元素
            int[] pair = queue.poll();
            List<Integer> item = new ArrayList<>();
            item.add(nums1[pair[0]]);
            item.add(nums2[pair[1]]);

            // 若我们假想的数组有下一个元素，则加入小顶堆
            if (pair[1] < nums2.length - 1) {
                queue.add(new int[] { pair[0], pair[1] + 1 });
            }
            res.add(item);
            k--;
        }
        return res;
    }
}
