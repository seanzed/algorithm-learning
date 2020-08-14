package com.sean.学习.跳表;

import java.util.Comparator;

/**
 * 跳表
 *
 * @author chenxu
 * @summary 跳表
 * @Copyright (c) 2020, Lianjia Group All Rights Reserved.
 * @since 2020-08-10 21:20
 */
public class SkipList<K, V> {

    /**
     * 跳表的最大层级
     */
    private static final int MAX_LEVEL = 32;

    /**
     * 跳表分层概率
     */
    private static final double P = 0.25;

    /**
     * 元素个数
     */
    private int size;

    /**
     * 比较器
     */
    private Comparator<K> comparator;

    private int level;

    private Node<K, V> first;

    public SkipList(Comparator<K> comparator) {
        this.comparator = comparator;
        first = new Node<>(null, null, MAX_LEVEL);
    }

    public SkipList() {
        this(null);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V>[] nexts;

        public Node(K key, V value, int level) {
            this.key = key;
            this.value = value;
            nexts = new Node[level];
        }

        @Override
        public String toString() {
            return key + ":" + value + "_" + nexts.length;
        }
    }
}
