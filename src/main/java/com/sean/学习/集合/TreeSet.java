package com.sean.学习.集合;

import com.sean.学习.二叉树.BinaryTree;
import com.sean.学习.二叉树.红黑树.RBTree;

import java.util.Comparator;

/**
 * TreeSet
 *
 * @author chenxu
 * @summary TreeSet
 * @Copyright (c) 2020, Lianjia Group All Rights Reserved.
 * @since 2020-09-08 23:15
 */
public class TreeSet<E> implements Set<E> {

    private RBTree<E> tree;

    public TreeSet() {
        this(null);
    }

    public TreeSet(Comparator<E> comparator) {
        tree = new RBTree<>(comparator);
    }

    /**
     * 元素长度
     *
     * @return {@link int}
     * @summary 元素长度
     * @author chenxu
     * @version v1
     * @since 2020-09-08 23:04:56
     */
    @Override
    public int size() {
        return tree.size();
    }

    /**
     * 集合是否为空
     *
     * @return {@link boolean}
     * @summary 集合是否为空
     * @author chenxu
     * @version v1
     * @since 2020-09-08 23:05:16
     */
    @Override
    public boolean isEmpty() {
        return tree.isEmpty();
    }

    /**
     * 清空集合
     *
     * @summary 清空集合
     * @author chenxu
     * @version v1
     * @since 2020-09-08 23:05:41
     */
    @Override
    public void clear() {
        tree.clear();
    }

    /**
     * 集合是否包含某个元素
     *
     * @return {@link boolean}
     * @summary 集合是否包含某个元素
     * @author chenxu
     * @version v1
     * @since 2020-09-08 23:06:03
     */
    @Override
    public boolean contains(E element) {
        return tree.contains(element);
    }

    /**
     * 添加元素
     *
     * @summary 添加元素
     * @author chenxu
     * @version v1
     * @since 2020-09-08 23:06:20
     */
    @Override
    public void add(E element) {
        tree.add(element);
    }

    /**
     * 删除元素
     *
     * @summary 删除元素
     * @author chenxu
     * @version v1
     * @since 2020-09-08 23:06:35
     */
    @Override
    public void remove(E element) {
        tree.remove(element);
    }

    /**
     * 遍历元素
     *
     * @summary 遍历元素
     * @author chenxu
     * @version v1
     * @since 2020-09-08 23:06:49
     */
    @Override
    public void traversal(Visitor<E> visitor) {

        tree.inorder(new BinaryTree.Visitor<E>() {

            @Override
            public boolean visit(E element) {
                return visitor.visit(element);
            }
        });
    }
}
