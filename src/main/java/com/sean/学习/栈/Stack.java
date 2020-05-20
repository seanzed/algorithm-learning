package com.sean.学习.栈;

import com.sean.学习.数组.List;
import com.sean.学习.数组.动态数组.ArrayList;

/**
 * description 栈
 *
 * @author chenxu 2020/05/19 23:19
 */
public class Stack<E> {

    private List<E> list = new ArrayList<>();

    /**
     * 清除数据接口
     */
    public void clear() {
        list.clear();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(E element) {
        list.add(element);
    }

    public E pop() {
        return list.remove(list.size() - 1);
    }

    public E top() {
        return list.get(list.size() - 1);
    }
}
