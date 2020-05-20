package com.sean.刷题.链表;

/**
 * description 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 *
 * @author chenxu 2020/05/19 22:24
 */
public class _876_链表的中间结点 {

    public ListNode middleNode(ListNode head) {
        if (head == null) return head;
        int size = 0;

        ListNode cur = head;
        while (cur != null) {
            ++size;
            cur = cur.next;
        }

        cur = head;
        int k = 0;
        while (k < size / 2) {
            ++k;
            cur = cur.next;
        }
        return cur;
    }
}
