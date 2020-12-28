package com.sean.刷题.剑指Offer;

/**
 * _剑指Offer_25_合并两个排序的链表
 *
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 *
 * 0 <= 链表长度 <= 1000
 *
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 *
 * @author chenxu
 * @summary _剑指Offer_25_合并两个排序的链表
 * @since 2020-12-18 23:36
 */
public class _剑指Offer_25_合并两个排序的链表 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
}
