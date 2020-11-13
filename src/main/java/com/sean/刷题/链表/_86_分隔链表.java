package com.sean.刷题.链表;

/**
 * _86_分隔链表
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 *  
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * 链接：https://leetcode-cn.com/problems/partition-list
 *
 * @author chenxu
 * @summary _86_分隔链表
 * @Copyright (c) 2020, Lianjia Group All Rights Reserved.
 * @since 2020-11-09 13:11
 */
public class _86_分隔链表 {

    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        ListNode lHead = new ListNode(0);
        ListNode lTail = lHead;
        ListNode rHead = new ListNode(0);
        ListNode rTail = rHead;
        while (head != null) {
            if (head.val < x) {
                lTail.next = head;
                lTail = head;
            } else {
                rTail.next = head;
                rTail = head;
            }
            head = head.next;
        }

        rTail.next = null;
        // 将rHead.next拼接在lTail后面
        lTail.next = rHead.next;
        return lHead.next;
    }
}
