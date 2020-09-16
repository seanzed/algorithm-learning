package com.sean.学习.优先级队列;

import com.sean.学习.堆.BinaryHeap;

import java.util.Comparator;

/**
 * 优先级队列
 *
 * @author chenxu
 * @summary 优先级队列
 * @since 2020-09-15 12:54
 */
public class PriorityQueue<E> {

    private BinaryHeap<E> heap;

    public PriorityQueue(Comparator<E> comparator) {
        heap = new BinaryHeap<E>(comparator);
    }

    public PriorityQueue() {
        this(null);
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void clear() {
        heap.clear();
    }

    public void enQueue(E element) {
        heap.add(element);
    }

    public E deQueue() {
        return heap.remove();
    }

    public E front() {
        return heap.get();
    }
}
