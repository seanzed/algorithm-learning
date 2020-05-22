package com.sean.队列;

/**
 * description 使用栈实现队列的下列操作：
 *
 * push(x) -- 将一个元素放入队列的尾部。 pop() -- 从队列首部移除元素。 peek() -- 返回队列首部的元素。 empty() -- 返回队列是否为空。
 *
 * https://leetcode-cn.com/problems/implement-queue-using-stacks
 *
 * @author chenxu 2020/05/19 23:59
 */
public class _232_用栈实现队列 {

    private int size = 0;

    private Integer[] elements;

    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Initialize your data structure here.
     */
    public _232_用栈实现队列() {
        elements = new Integer[DEFAULT_CAPACITY];
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        ensureCapacity(size + 1);
        elements[size++] = x;
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        int oldElement = elements[0];
        for (int i = 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        elements[--size] = null;
        return oldElement;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return elements[0];
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return size == 0;
    }

    private int index(int index) {
        rangeCheck(index);
        return elements[index];
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
        }
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity > capacity) return;

        int newCapacity = oldCapacity + oldCapacity >> 1;
        Integer[] newElements = new Integer[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[index(i)];
        }
        elements = newElements;
    }
}
