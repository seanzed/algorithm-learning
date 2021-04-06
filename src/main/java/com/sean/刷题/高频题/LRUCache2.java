package com.sean.刷题.高频题;

import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {

    private Map<Integer, Node> map;

    private int capacity;

    // 虚拟头结点
    private Node first;

    // 虚拟尾结点
    private Node last;

    public LRUCache2(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        // 虚拟头结点
        first = new Node();
        first.next = last;
        last.prev = first;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node ==  null) return -1;

        removeNode(node);
        addAfterFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            removeNode(node);
        } else {
            if (map.size() == capacity) {
                // 淘汰最近最少使用的node
                removeNode(map.remove(last.prev.key));
            }
            map.put(key, node = new Node(key, value));
        }
        addAfterFirst(node);

    }

    private void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void addAfterFirst(Node node) {
        node.next = first.next;
        first.next.prev = node;

        // node 和first
        first.next = node;
        node.prev = first;
    }

    private static class Node {
        int key;

        int value;

        Node prev;

        Node next;

        public Node (int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {}
    }
}
