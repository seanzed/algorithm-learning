package com.sean.学习.排序.sort.cmp;

import com.sean.学习.排序.sort.Sort;

/**
 * description 插入排序
 *
 * @author chenxu 2020/05/31 11:26
 */
public class InsertionSort1<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            int cur = begin;
            while(cur >0 && cmp(array[cur], array[cur -1]) < 0) {
                swap(cur, cur -1);
                cur--;
            }
        }
    }
}
