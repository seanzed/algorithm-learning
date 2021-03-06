package com.sean.刷题.双指针;

/**
 * _剑指_Offer_22_链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 *
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 *
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 *
 * @author chenxu
 * @summary _剑指_Offer_22_链表中倒数第k个节点
 * @since 2020-08-29 09:12
 */
public class _剑指_Offer_22_链表中倒数第k个节点 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode left = head, right = head;

        while (right != null) {
            right = right.next;
            if (k > 0) {
                k--;
            } else {
                left = left.next;
            }
        }
        return left;
    }
}
