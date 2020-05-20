package com.sean.刷题.链表;

/**
 * description 反转一个单链表。
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author chenxu 2020/04/28 22:33
 */
public class _206_反转链表 {

    /**
     * 递归版本
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newNode;
    }

    /**
     * 非递归版本
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newNode = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = newNode;
            newNode = head;
            head = tmp;
        }
        return newNode;
    }

}
