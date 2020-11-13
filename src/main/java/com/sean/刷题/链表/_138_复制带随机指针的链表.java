package com.sean.刷题.链表;

import com.sean.学习.哈希表.map.HashMap;

/**
 * _138_复制带随机指针的链表
 *
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 *
 * 要求返回这个链表的 深拷贝。 
 *
 * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 *
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
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
 *
 * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
 *
 * @author chenxu
 * @summary _138_复制带随机指针的链表
 * @since 2020-11-13 14:59
 */
public class _138_复制带随机指针的链表 {

    HashMap<Node, Node> vistedHash = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        if (this.vistedHash.containsKey(head)) {
            return this.vistedHash.get(head);
        }

        Node node = new Node(head.val, null, null);

        this.vistedHash.put(head, node);

        node.next = this.copyRandomList(head.next);
        node.random = this.copyRandomList(head.random);
        return node;
    }

    public Node copyRandomList1(Node head) {
        if (head == null) return null;
        Node ptr = head;
        while (ptr != null) {
            Node newNode = new Node(ptr.val);
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }

        ptr = head;

        while (ptr != null) {
            ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
            ptr = ptr.next.next;
        }

        Node ptr_old_list = head; // A->B->C
        Node ptr_new_list = head.next; // A'->B'->C'
        Node head_old = head.next;
        while (ptr_old_list != null) {
            ptr_old_list.next = ptr_old_list.next.next;
            ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
            ptr_old_list = ptr_old_list.next;
            ptr_new_list = ptr_new_list.next;
        }
        return head_old;
    }
}
