package com.sean.刷题.双指针;

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
 * @since 2020-08-30 18:50
 */
public class _234_回文链表 {

    public boolean isPalindrome(ListNode head) {
        //如果链表为空或者链表只有一个元素，那么一定返回true
        if (head == null || head.next == null) return true;

       ListNode q = head, p = head, pre = null;
        //循环结束后p指向(int)(n/2)号节点，n为链表长度，索引从0开始
        while (q != null && q.next != null) {
            // q每次向后移动两次
            q = q.next.next;
            ListNode tmp = p.next;
            //p的next指针反向
            p.next = pre;
            //移动pre
            pre = p;
            //移动p
            p = tmp;
        }

        //链表长度为奇数，此时pre指向(int)(n/2)-1号元素，p指向(int)(n/2)号元素
        if (q != null) {
            //p向后移动一位
            p = p.next;
        }
        //判断是否回文
        while (p != null && pre != null) {
            if (p.val != pre.val)
                return false;
            p = p.next;
            pre = pre.next;
        }
        return true;

    }
}
