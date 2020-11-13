package com.sean.刷题.链表;

/**
 * _234_回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 *
 * @author chenxu
 * @summary _234_回文链表
 * @since 2020-11-10 10:53
 */
public class _234_回文链表 {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        if (head.next.next == null) return head.val == head.next.val;

        // 找到中间节点
        ListNode mid = middleNode(head);
        // 翻转右半部分
        ListNode rHead = reverseList(mid.next);
        ListNode lHead = head;
        ListNode  rOldHead = rHead;
        // 从lHead、rHead出发，判断是否为回文链表
        boolean result = true;
        while (rHead != null) {
            if (lHead.val != rHead.val) {
                result = false;
                break;
            }
            rHead = rHead.next;
            lHead = lHead.next;
        }

        // 恢复右半部分（对右半部分再次翻转）
        reverseList(rOldHead);
        return result;
    }

    /**
     * 找到中间节点
     *
     * @param   head
     * @return  {@link ListNode}
     * @summary 找到中间节点
     * @version v1
     * @since 2020-11-10 10:58:24
     */
    private ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 翻转链表
     *
     * @param   head
     * @return  {@link ListNode}
     * @summary 翻转链表
     * @author chenxu
     * @version v1
     * @since 2020-11-10 11:00:32
     */
    private ListNode reverseList(ListNode head) {
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
