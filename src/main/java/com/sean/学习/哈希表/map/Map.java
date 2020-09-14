package com.sean.学习.哈希表.map;

/**
 * Map
 *
 * @author chenxu
 * @summary Map
 * @since 2020-09-10 08:37
 */
public interface Map<K, V> {

    /**
     * 元素大小
     *
     * @return  {@link int}
     * @summary 元素大小
     * @author chenxu
     * @version v1
     * @since 2020-09-10 08:40:52
     */
    int size();

    /**
     * 元素个数是否为空
     *
     * @return  {@link boolean}
     * @summary 元素个数是否为空
     * @author chenxu
     * @version v1
     * @since 2020-09-10 08:41:16
     */
    boolean isEmpty();

    /**
     * 清空元素
     *
     * @summary 清空元素
     * @author chenxu
     * @version v1
     * @since 2020-09-10 08:41:42
     */
    void clear();

    /**
     * 添加一个元素
     *
     * @param   key
     * @param   value
     * @return  {@link V}
     * @summary 添加一个元素
     * @author chenxu
     * @version v1
     * @since 2020-09-10 08:41:59
     */
    V put(K key, V value);

    /**
     * 根据key获取对应的value
     *
     * @param   key
     * @return  {@link V}
     * @summary 根据key获取对应的value
     * @author chenxu
     * @version v1
     * @since 2020-09-10 08:42:14
     */
    V get(K key);

    /**
     * 根据key删除一个元素
     *
     * @param   key
     * @return  {@link V}
     * @summary 根据key删除一个元素
     * @author chenxu
     * @version v1
     * @since 2020-09-10 08:42:46
     */
    V remove(K key);

    /**
     * 查看哈希表是否包含某个key
     *
     * @param   key
     * @return  {@link boolean}
     * @summary 查看哈希表是否包含某个key
     * @author chenxu
     * @version v1
     * @since 2020-09-10 08:43:03
     */
    boolean containsKey(K key);

    /**
     * 查看哈希表是否包含某个value
     *
     * @param   value
     * @return  {@link boolean}
     * @summary 查看哈希表是否包含某个value
     * @author chenxu
     * @version v1
     * @since 2020-09-10 08:43:25
     */
    boolean containsValue(V value);

    /**
     * 遍历哈希表
     *
     * @param   visitor
     * @return  {@lnk void}
     * @summary 遍历哈希表
     * @author chenxu
     * @version v1
     * @since 2020-09-10 08:43:50
     */
    void traversal(Visitor<K, V> visitor);

    public static abstract class Visitor<K, V> {
        boolean stop;
        public abstract boolean visit(K key, V value);
    }
}
