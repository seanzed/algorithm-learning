package com.sean.学习.数组.test;

/**
 * List
 *
 * @author chenxu
 * @summary List
 * @since 2020-08-14 23:37
 */
public interface List<E> {

    static final int ELEMENT_NOT_FOUND = -1;

    //添加元素element
    void add(E element);

    //在index添加元素element
    void add(int index, E element);

    //移除元素element
    void remove(E element);

    //删除index位置元素，并返回删除元素
    E remove(int index);

    //清空线性表
    void clear();

    //设置index位置为element
    E set(int index, E element);

    //获取线性表大小
    int size();

    //获取element首次出现位置
    int indexOf(E element);

    //获取index位置元素
    E get(int index);

    //判断线性表是否为空
    boolean isEmpty();

    //判断是否包含元素element
    boolean contains(E element);

}

