package com.sean.学习.集合;

import com.sean.学习.数组.List;
import com.sean.学习.数组.链表.LinkedList;


/**
 * ListSet
 *
 * @author chenxu
 * @summary ListSet
 * @since 2020-09-08 23:07
 */
public class ListSet<E> implements Set<E> {

    private List<E> list = new LinkedList<>();

    /**
     * 元素长度
     *
     * @return {@link int}
     * @summary 元素长度
     * @author chenxu
     * @version v1
     * @since 2020-09-08 23:04:56
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * 集合是否为空
     *
     * @return {@link boolean}
     * @summary 集合是否为空
     * @author chenxu
     * @version v1
     * @since 2020-09-08 23:05:16
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 清空集合
     *
     * @summary 清空集合
     * @author chenxu
     * @version v1
     * @since 2020-09-08 23:05:41
     */
    @Override
    public void clear() {
        list.clear();
    }

    /**
     * 集合是否包含某个元素
     *
     * @return {@link boolean}
     * @summary 集合是否包含某个元素
     * @author chenxu
     * @version v1
     * @since 2020-09-08 23:06:03
     */
    @Override
    public boolean contains(E element) {
        return list.contains(element);
    }

    /**
     * 添加元素
     *
     * @summary 添加元素
     * @author chenxu
     * @version v1
     * @since 2020-09-08 23:06:20
     */
    @Override
    public void add(E element) {
        int index = list.indexOf(element);
        if (index != List.ELEMENT_NOT_FOUND) {
            // 存在就覆盖
            list.set(index, element);
        } else {
            // 不存在就添加
            list.add(element);
        }
    }

    /**
     * 删除元素
     *
     * @summary 删除元素
     * @author chenxu
     * @version v1
     * @since 2020-09-08 23:06:35
     */
    @Override
    public void remove(E element) {
        int index = list.indexOf(element);
        if (index != List.ELEMENT_NOT_FOUND) {
            list.remove(index);
        }
    }

    /**
     * 遍历元素
     *
     * @summary 遍历元素
     * @author chenxu
     * @version v1
     * @since 2020-09-08 23:06:49
     */
    @Override
    public void traversal(Visitor<E> visitor) {
        if (visitor == null) return;

        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (visitor.visit(list.get(i))) return;
        }
    }
}
