package com.sean.刷题.剑指Offer;

import com.sean.学习.数组.List;
import com.sean.学习.数组.动态数组.ArrayList;
import com.sean.学习.栈.Stack;

import java.util.LinkedList;

/**
 * _剑指_Offer_06_从尾到头打印链表
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *   
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *   
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 *
 * @author chenxu
 * @summary _剑指_Offer_06_从尾到头打印链表
 * @since 2020-09-05 10:15
 */
public class _剑指Offer_06_从尾到头打印链表 {

    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while(head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = stack.removeLast();
        }
        return res;
    }

    public int[] reversePrint1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode tmp = head;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }

        int size = stack.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            ListNode node = stack.pop();
            res[i] = node.val;
        }
        return res;
    }
}
