package com.sean.学习.排序.sort.cmp;

import com.sean.学习.排序.sort.Sort;

/**
 * description 冒泡排序
 *
 * @author chenxu 2020/05/31 11:21
 */
public class BubbleSort2<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            // 如果已经全部有序，提前终止
            boolean sorted = true;
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(begin, begin - 1) < 0) {
                    swap(begin, begin - 1);
                    sorted = false;
                }
            }

            if (sorted) {
                break;
            }
        }
    }
}
