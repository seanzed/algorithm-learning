package com.sean.学习.堆;

/**
 * description 怼
 *
 * @author xchen11 2020/05/25 09:36
 */
public interface Heap<E> {

    /**
     * 元素的数量
     * @return
     */
    int size();

    /**
     * 堆是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 清空堆
     */
    void clear();

    /**
     * 添加元素
     * @param element
     */
    void add(E element);

    /**
     * 获取堆顶元素
     * @return
     */
    E get();

    /**
     * 移除堆顶元素
     * @return
     */
    E remove();

    /**
     * 删除堆顶元素的同时插入一个新元素
     * @param element
     * @return
     */
    E replace(E element);

}
