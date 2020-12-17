package com.sean.刷题.链表;

/**
 * description 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 *
 * @author chenxu 2020/05/19 22:23
 */
public class _83_删除排序链表中的重复元素 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) return null;
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {

            if (prev.val == cur.val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }

}
