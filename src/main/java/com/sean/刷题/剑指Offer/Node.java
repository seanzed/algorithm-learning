package com.sean.刷题.剑指Offer;

/**
 * Node
 *
 * @author chenxu
 * @summary Node
 * @since 2020-11-13 15:00
 */
public class Node {

    int val;

    Node next;

    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Node(int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}
