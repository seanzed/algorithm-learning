package com.sean.刷题.剑指Offer;

import java.util.HashMap;
import java.util.Map;

/**
 * _剑指Offer_35_复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 *
 *
 *
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 *
 *
 *
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 *
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 *  
 *
 * 提示：
 *
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 *  
 *
 *
 *
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 *
 * @author chenxu
 * @summary _剑指Offer_35_复杂链表的复制
 * @since 2020-09-23 12:39
 */
public class _剑指Offer_35_复杂链表的复制 {

    Map<Node, Node> nodeMap = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) return head;

        Node copy = new Node(head.val);
        nodeMap.put(head, copy);
        copy.next = copyRandomList(head.next);
        copy.random = nodeMap.get(head.random);
        return copy;
    }

    class Node {
        int val;

        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
