package com.sean.学习.堆;

import com.sean.学习.二叉树.printer.BinaryTreeInfo;
import java.util.Comparator;

/**
 * description 二叉堆
 *
 * @author xchen11 2020/05/25 09:42
 */
public class BinaryHeap<E> extends AbstractHeap<E> implements BinaryTreeInfo {

    /**
     * 元素数组
     */
    private E[] elements;

    /**
     * 默认数组长度
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 有参构造函数
     *
     * @param elements 数组
     * @param comparator 比较器
     */
    public BinaryHeap(E[] elements, Comparator<E> comparator) {
        super(comparator);
        if (elements == null || elements.length == 0) {
            this.elements = (E[]) new Object[DEFAULT_CAPACITY];
        } else {
            size = elements.length;
            int capacity = Math.max(elements.length, DEFAULT_CAPACITY);
            this.elements = (E[]) new Object[capacity];
            for (int i = 0; i < elements.length; i++) {
                this.elements[i] = elements[i];
            }
            heapify();
        }
    }

    /**
     * 有参构造函数
     *
     * @param elements 数组
     */
    public BinaryHeap(E[] elements) {
        this(elements, null);
    }

    /**
     * 无参构造函数
     */
    public BinaryHeap() {
        this(null, null);
    }

    @Override
    public void clear() {
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public void add(E element) {
        elementNotNullCheck(element);
        ensureCapacity(size + 1);
        elements[size++] = element;
        // 元素上滤
        siftUp(size - 1);
    }

    @Override
    public E get() {
        emptyCheck();
        return elements[0];
    }

    @Override
    public E remove() {
        emptyCheck();

        int lastIndex = --size;
        E root = elements[0];
        elements[0] = elements[lastIndex];
        elements[lastIndex] = null;
        // 元素下滤
        siftDown(0);
        return root;
    }

    @Override
    public E replace(E element) {
        elementNotNullCheck(element);

        E root = null;
        if (size == 0) {
            elements[0] = element;
            size++;
        } else {
            root = elements[0];
            elements[0] = element;
            siftDown(0);
        }
        return root;
    }

    /**
     * 堆化
     */
    private void heapify() {
        // 自上而下的上滤
//		for (int i = 1; i < size; i++) {
//			siftUp(i);
//		}

        // 自下而上的下滤
        for (int i = (size >> 1) - 1; i >= 0; i--) {
            siftDown(i);
        }
    }

    /**
     * 让index位置元素下滤
     *
     * @param index index 位置
     */
    private void siftDown(int index) {
        E element = elements[index];
        int half = size >> 1;

        // 第一个叶子节点的索引 == 非叶子节点的数量
        // index < 第一个叶子节点的索引
        // 必须保证index位置是非叶子节点
        while (index < half) {
            // index的节点有两种情况
            // 1. 只有左节点
            // 2. 既有左节点又有右节点

            // 默认左节点跟它进行比较
            int childIndex = (index << 1) + 1;
            E child = elements[childIndex];

            // 右子节点
            int rightIndex = childIndex + 2;
            // 选出左右子节点最大的那个
            if (rightIndex < size && compare(elements[rightIndex], child) > 0) {
                child = elements[childIndex = rightIndex];
            }

            // 如果element 比当前元素大就退出循环
            if (compare(element, child) >= 0) {
                break;
            }

            // 将子节点放在index位置
            elements[index] = child;

            // 重新设置index
            index = childIndex;
        }

        elements[index] = element;
    }

    /**
     * 让index 位置元素上滤
     *
     * @param index index位置
     */
    private void siftUp(int index) {
        //		E e = elements[index];
//		while (index > 0) {
//			int pindex = (index - 1) >> 1;
//			E p = elements[pindex];
//			if (compare(e, p) <= 0) return;
//
//			// 交换index、pindex位置的内容
//			E tmp = elements[index];
//			elements[index] = elements[pindex];
//			elements[pindex] = tmp;
//
//			// 重新赋值index
//			index = pindex;
//		}

        E element = elements[index];

        while (index > 0) {
            int parentIndex = (index - 1) >> 1;
            E parentElement = elements[parentIndex];
            if (compare(element, parentElement) <= 0) {
                break;
            }
            // 将父元素存储在index位置
            elements[index] = parentElement;
            // 重新复制index
            index = parentIndex;
        }

        elements[index] = element;
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) {
            return;
        }

        // 新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + oldCapacity >> 1;
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }

        elements = newElements;
    }

    /**
     * 数组为空校验
     */
    private void emptyCheck() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Head is Empty");
        }
    }

    /**
     * 元素不为空校验
     */
    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    @Override
    public Object root() {
        return 0;
    }

    @Override
    public Object left(Object node) {
        int index = ((int) node << 1) + 1;
        return index >= size ? null : index;
    }

    @Override
    public Object right(Object node) {
        int index = ((int) node << 1) + 2;
        return index >= size ? null : index;
    }

    @Override
    public Object string(Object node) {
        return elements[(int) node];
    }

}
