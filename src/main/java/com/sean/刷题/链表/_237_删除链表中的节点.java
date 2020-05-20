package com.sean.刷题.链表;

/**
 * description https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 *
 * @author chenxu 2020/04/28 22:21
 */
public class _237_删除链表中的节点 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
