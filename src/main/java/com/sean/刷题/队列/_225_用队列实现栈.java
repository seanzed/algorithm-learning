package com.sean.刷题.队列;

/**
 * description 使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈 pop() -- 移除栈顶元素 top() -- 获取栈顶元素 empty() -- 返回栈是否为空
 *
 * https://leetcode-cn.com/problems/implement-stack-using-queues
 *
 * @author chenxu 2020/05/20 00:22
 */
public class _225_用队列实现栈 {

    private int size = 0;

    private Integer[] elements;

    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Initialize your data structure here.
     */
    public _225_用队列实现栈() {
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
        int oldElement = elements[size - 1];
        elements[--size] = null;
        return oldElement;
    }

    /**
     * Get the front element.
     */
    public int top() {
        return elements[size - 1];
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
