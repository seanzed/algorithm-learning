package com.sean.学习.队列;

import java.util.LinkedList;
import java.util.List;

/**
 * description 队列
 *
 * @author chenxu 2020/05/19 23:51
 */
public class Queue<E> {

    private List<E> list = new LinkedList<>();

    /**
     * 查看队列长度
     *
     * @return 队列长度
     */
    public int size() {
        return list.size();
    }

    /**
     * 查看队列是否为空
     *
     * @return 返回结果
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 清除队列数据
     */
    public void clear() {
        list.clear();
    }

    /**
     * 入队
     *
     * @param element 入队数据
     */
    public void enQueue(E element) {
        list.add(element);
    }

    /**
     * 出队
     *
     * @return 出队数据
     */
    public E deQueue() {
        return list.remove(0);
    }

    /**
     * 队头
     */
    public E front() {
        return list.get(0);
    }

}
