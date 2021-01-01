package com.sean.刷题.剑指Offer;

/**
 * _剑指Offer_18_删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 注意：此题对比原题有改动
 *
 * 示例 1:
 *
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为  5  的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 *
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为  1  的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *   
 *
 * 说明：
 *
 * 题目保证链表中节点的值互不相同
 * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 *
 * 链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof
 *
 * @author chenxu
 * @summary _剑指Offer_18_删除链表的节点
 * @since 2020-09-09 09:04
 */
public class _剑指Offer_18_删除链表的节点 {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) {
            return head.next;
        }
        ListNode cur = head;
        // 找到要删除的上一个节点
        while (cur.next != null && cur.next.val != val) {
            cur = cur.next;
        }
        // 删除节点
        cur.next = cur.next.next;
        return head;
    }

    public ListNode deleteNode1(ListNode head, int val) {
        if (head == null) return head;

        if (head.val == val) {
            return head.next;
        }
        head.next = deleteNode1(head.next, val);
        return head;
    }
}
