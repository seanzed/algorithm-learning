package com.sean.刷题.二叉树.完美二叉树;

import java.util.List;

/**
 * description
 *
 * @author chenxu 2020/05/07 00:26
 */
public class Node {

    public int val;
    public Node left;

    public Node right;

    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        this.val = _val;
        this.left = _left;
        this.right = _right;
        this.next = _next;
    }
}
