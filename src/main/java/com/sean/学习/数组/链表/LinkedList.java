package com.sean.学习.数组.链表;

import com.sean.学习.数组.AbstractList;

/**
 * description 链表
 *
 * @author chenxu 2020/05/06 20:22
 */
public class LinkedList<E> extends AbstractList<E> {

    private class Node<E> {
        E element;

        /**
         * 前驱节点
         */
        Node<E> prev;

        /**
         * 后继节点
         */
        Node<E> next;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }

    @Override
    public void clear() {

    }
}
