package com.sean.学习.排序.sort.cmp;

import com.sean.学习.排序.sort.Sort;

/**
 * description 堆排序
 *
 * @author chenxu 2020/05/31 11:36
 */
public class HeapSort<T extends Comparable<T>> extends Sort<T> {

    private int heapSize;

    @Override
    protected void sort() {
        // 原地建堆
        heapSize = this.array.length;
        for (int i = (heapSize >> 1) - 1 ; i >= 0; i--) {
            siftDown(i);
        }

        while (heapSize > 1) {
            // 交换堆顶元素和尾部元素
            swap(0, --heapSize);

            // 对0位置进行siftDown（恢复堆的性质）
            siftDown(0);
        }

    }

    /**
     * 下滤操作
     * @param index
     */
    private void siftDown(int index) {
        T element = array[index];

        int half = heapSize >> 1;
        // index必须是非叶子节点
        while(index < half) {
            // 默认是左子节点跟父节点比较
            int childIndex = (index << 1) + 1;
            T child = array[childIndex];

            int rightIndex = childIndex + 1;
            // 右子节点比左子节点大
            if (rightIndex < heapSize && cmp(array[rightIndex], child) > 0) {
                child = array[childIndex = rightIndex];
            }

            // 大于等于子节点，退出循环
            if (cmp(element, child) >= 0) break;
            index = childIndex;
        }
        array[index] = element;
    }
}
