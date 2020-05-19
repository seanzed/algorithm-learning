package com.sean.学习.数组;

/**
 * description 数组接口
 *
 * @author chenxu 2020/05/19 11:25
 */
public interface List<E> {

    static final int ELEMENT_NOT_FOUND = -1;

    /**
     * 添加元素到尾部
     * @param element
     */
    void add(E element);

    /**
     * 获取index位置的元素
     * @param index index位置
     * @return
     */
    E get(int index);

    /**
     * 设置index位置元素的值
     * @param index index位置
     * @param element 元素值
     */
    E set(int index, E element);

    /**
     * 在index位置插入一个元素
     * @param index index位置
     * @param element element元素
     */
    void add(int index, E element);

    /**
     * 删除index位置的元素
     * @param index
     * @return
     */
    E remove(int index);

    /**
     * 查看元素的索引
     * @param element
     * @return
     */
    int indexOf(E element);

    /**
     * 清除所有元素
     */
    void clear();

    /**
     * 元素的数量
     * @return
     */
    int size();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 是否包含某个元素
     * @param element 元素
     * @return 是否包含某个元素
     */
    boolean contains(E element);
}
