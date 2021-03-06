package com.sean.刷题.链表;

/**
 * description 删除链表中等于给定值 val 的所有节点。
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 *
 * @author chenxu 2020/05/19 22:22
 */
public class _203_移除链表元素 {

    public ListNode removeElements(ListNode head, int val) {
        // 虚拟头结点
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode prev = sentinel, curr = head;
        while (curr != null) {
            if (curr.val == val) prev.next = curr.next;
            else prev = curr;
            curr = curr.next;
        }
        return sentinel.next;
    }

    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) return null;

        // 新链表的头结点
        ListNode newHead = new ListNode(0);
        // 新链表的尾结点
        ListNode newTail = newHead;
        while (head != null) {
            if (head.val != val) {
                newTail.next = head;
                newTail = head;
            }
            head = head.next;
        }
        newTail.next = null;
        return newHead.next;
    }
}
