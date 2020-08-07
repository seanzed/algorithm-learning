package com.sean.学习.排序.sort.cmp;

import com.sean.学习.排序.sort.Sort;

/**
 * description 插入排序
 *
 * @author chenxu 2020/05/31 11:26
 */
public class InsertionSort2<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            int cur = begin;
            T tmp = array[cur];
            while (cur > 0 && cmp(array[cur], array[cur - 1]) < 0) {
                array[cur] = array[cur - 1];
                cur--;
            }

            array[cur] = tmp;
        }
    }
}
