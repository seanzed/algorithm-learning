package com.sean.刷题.链表;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * description 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * @author xchen11 2020/05/25 11:21
 */
public class _23_合并K个排序链表 {


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        Queue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.offer(lists[i]);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            curr.next = node;
            if (node.next != null) {
                queue.offer(node.next);
            }
            curr = curr.next;
        }
        curr.next = null;
        return dummy.next;
    }

}
