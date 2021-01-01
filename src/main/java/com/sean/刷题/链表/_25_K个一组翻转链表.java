package com.sean.刷题.链表;

/**
 * _25_K个一组翻转链表
 * 给你一个链表，每  k  个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k  是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是  k  的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *   
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当  k  = 2 时，应当返回: 2->1->4->3->5
 *
 * 当  k  = 3 时，应当返回: 3->2->1->4->5
 *
 *   
 *
 * 说明：
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 *
 * @author chenxu
 * @summary _25_K个一组翻转链表
 * @since 2020-11-13 15:20
 */
public class _25_K个一组翻转链表 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            // 剩余数量小于k的话， 则不需要反转
            if (tail == null) {
                return head;
            }

            tail = tail.next;
        }

        // 反转钱k个元素
        ListNode newHead = reverse(head, tail);

        // 下一轮的开始的地方就是tail
        head.next = reverseKGroup(tail, k);

        return newHead;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode next = null;
        while (head != tail) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
