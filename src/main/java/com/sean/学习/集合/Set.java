package com.sean.学习.集合;

/**
 * 集合接口
 *
 * @author chenxu
 * @summary 集合接口
 * @since 2020-09-08 23:02
 */
public interface Set<E> {

    /**
     * 元素长度
     *
     * @return  {@link int}
     * @summary 元素长度
     * @author chenxu
     * @version v1
     * @since 2020-09-08 23:04:56
     */
    int size();

    /**
     * 集合是否为空
     *
     * @return  {@link boolean}
     * @summary 集合是否为空
     * @author chenxu
     * @version v1
     * @since 2020-09-08 23:05:16
     */
    boolean isEmpty();

    /**
     * 清空集合
     *
     * @summary 清空集合
     * @author chenxu
     * @version v1
     * @since 2020-09-08 23:05:41
     */
    void clear();

    /**
     * 集合是否包含某个元素
     *
     * @param   element
     * @return  {@link boolean}
     * @summary 集合是否包含某个元素
     * @author chenxu
     * @version v1
     * @since 2020-09-08 23:06:03
     */
    boolean contains(E element);

    /**
     * 添加元素
     *
     * @param   element
     * @summary 添加元素
     * @author chenxu
     * @version v1
     * @since 2020-09-08 23:06:20
     */
    void add(E element);

    /**
     * 删除元素
     *
     * @param   element
     * @summary 删除元素
     * @author chenxu
     * @version v1
     * @since 2020-09-08 23:06:35
     */
    void remove(E element);

    /**
     * 遍历元素
     *
     * @param   visitor
     * @summary 遍历元素
     * @author chenxu
     * @version v1
     * @since 2020-09-08 23:06:49
     */
    void traversal(Visitor<E> visitor);

    public static abstract class Visitor<E> {
        boolean stop;
        public abstract boolean visit(E element);
    }
}
