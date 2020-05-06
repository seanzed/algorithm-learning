package com.sean.链表;

/**
 * description
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * https://leetcode-cn.com/problems/linked-list-cycle/
 *
 * @author chenxu 2020/04/28 22:47
 */
public class _141_环形链表 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)  return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (fast == slow) return true;
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

}
