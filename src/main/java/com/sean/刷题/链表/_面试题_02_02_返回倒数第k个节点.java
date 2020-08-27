package com.sean.刷题.链表;

/**
 * _面试题_02_02_返回倒数第k个节点
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例：
 *
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 *
 * 链接：https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci
 *
 * @author chenxu
 * @summary _面试题_02_02_返回倒数第k个节点
 * @Copyright (c) 2020, Lianjia Group All Rights Reserved.
 * @since 2020-08-23 23:42
 */
public class _面试题_02_02_返回倒数第k个节点 {

    public int kthToLast(ListNode head, int k) {
        ListNode left = head, right = head;
        while (right != null) {
            right = right.next;
            // 右指针动，左指针不动，每循环一次，两个指针间的距离就会拉开
            if (k > 0) {
                k--;
            } else {
                // 当到达预定的距离后，左指针也开始动，距离保持不变
                left = left.next;
            }
        }
        return left.val;
    }
}
