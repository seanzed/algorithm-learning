package com.sean.学习.堆;

import java.util.Comparator;

/**
 * description 堆接口的抽象类
 *
 * @author xchen11 2020/05/25 09:39
 */
public abstract class AbstractHeap<E> implements Heap<E> {

    /**
     * 元素长度
     */
    protected int size;

    /**
     * 比较器
     */
    protected Comparator<E> comparator;

    public AbstractHeap(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public AbstractHeap() {
        this(null);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    protected int compare(E e1, E e2) {
        return comparator != null ? comparator.compare(e1, e2)
            : ((Comparable<E>)e1).compareTo(e2);
    }
}
