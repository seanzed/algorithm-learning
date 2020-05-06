package com.sean.链表;

/**
 * description 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 *
 * @author chenxu 2020/04/28 22:34
 */
public class _24_反转链表 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newNode;
    }

}
