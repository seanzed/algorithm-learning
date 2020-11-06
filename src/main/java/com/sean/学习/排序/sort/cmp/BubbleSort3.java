package com.sean.学习.排序.sort.cmp;

import com.sean.学习.排序.sort.Sort;

/**
 * description 冒泡排序
 *
 * @author chenxu 2020/05/31 11:21
 */
public class BubbleSort3<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            int sortedIndex = 1;
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(begin, begin - 1) < 0) {
                    swap(begin, begin - 1);
                    sortedIndex = begin;
                }
            }

            end = sortedIndex;
        }
    }
}
