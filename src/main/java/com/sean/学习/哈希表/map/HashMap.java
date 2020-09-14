package com.sean.学习.哈希表.map;

import com.sean.刷题.二叉树.Node;

/**
 * HashMap
 *
 * @author chenxu
 * @summary HashMap
 * @since 2020-09-10 08:44
 */
public class HashMap<K, V> implements Map<K, V> {

    private static final boolean RED = false;

    private static final boolean BLACK = true;

    private int size;

    private Node<K, V>[] table;

    private static final int DEFAULT_CAPACITY = 1 << 4;

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    public HashMap() {
        table = new Node[DEFAULT_CAPACITY];
    }

    /**
     * 元素大小
     *
     * @return {@link int}
     * @summary 元素大小
     * @author chenxu
     * @version v1
     * @since 2020-09-10 08:40:52
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 元素个数是否为空
     *
     * @return {@link boolean}
     * @summary 元素个数是否为空
     * @author chenxu
     * @version v1
     * @since 2020-09-10 08:41:16
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 清空元素
     *
     * @summary 清空元素
     * @author chenxu
     * @version v1
     * @since 2020-09-10 08:41:42
     */
    @Override
    public void clear() {
        if (size == 0) return;
        size = 0;
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
    }

    /**
     * 添加一个元素
     *
     * @return {@link V}
     * @summary 添加一个元素
     * @author chenxu
     * @version v1
     * @since 2020-09-10 08:41:59
     */
    @Override
    public V put(K key, V value) {
        return null;
    }

    /**
     * 根据key获取对应的value
     *
     * @return {@link V}
     * @summary 根据key获取对应的value
     * @author chenxu
     * @version v1
     * @since 2020-09-10 08:42:14
     */
    @Override
    public V get(K key) {
        return null;
    }

    /**
     * 根据key删除一个元素
     *
     * @return {@link V}
     * @summary 根据key删除一个元素
     * @author chenxu
     * @version v1
     * @since 2020-09-10 08:42:46
     */
    @Override
    public V remove(K key) {
        return null;
    }

    /**
     * 查看哈希表是否包含某个key
     *
     * @return {@link boolean}
     * @summary 查看哈希表是否包含某个key
     * @author chenxu
     * @version v1
     * @since 2020-09-10 08:43:03
     */
    @Override
    public boolean containsKey(K key) {
        return false;
    }

    /**
     * 查看哈希表是否包含某个value
     *
     * @return {@link boolean}
     * @summary 查看哈希表是否包含某个value
     * @author chenxu
     * @version v1
     * @since 2020-09-10 08:43:25
     */
    @Override
    public boolean containsValue(V value) {
        return false;
    }

    /**
     * 遍历哈希表
     *
     * @return {@lnk void}
     * @summary 遍历哈希表
     * @author chenxu
     * @version v1
     * @since 2020-09-10 08:43:50
     */
    @Override
    public void traversal(Visitor<K, V> visitor) {

    }

    protected static class Node<K, V> {

        int hash;

        K key;

        V value;

        boolean color = RED;

        Node<K, V> node;

        Node<K, V> left;

        Node<K, V> right;

        Node<K, V> parent;

        public Node(K key, V value, Node<K, V> parent) {
            this.key = key;
            this.hash = key == null ? 0 : key.hashCode();
            this.value = value;
            this.parent = parent;
        }

        public boolean hasTwoChildren() {
            return left != null && right != null;
        }

        public boolean isLeftChild() {
            return parent != null && this == parent.left;
        }

        public boolean isRightChild() {
            return parent != null && this == parent.right;
        }

        public Node<K, V> sibling() {
            if (isLeftChild()) {
                return parent.right;
            }

            if (isRightChild()) {
                return parent.left;
            }

            return null;
        }

        @Override
        public String toString() {
            return "Node_" + key + "_" + value;
        }
    }
}
