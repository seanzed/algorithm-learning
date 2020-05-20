package com.sean.刷题.排序;

/**
 * description 快速排序
 *
 * @author chenxu 2020/04/06 21:14
 */
public class QuickSort {

    public static void quickSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int l, int r) {
        if (l < r) {
            int randomInt = (int) Math.random() * (r - l + 1);
            swap(array, l + randomInt, r);

            int[] p = partition(array, l, r);
            quickSort(array, l, p[0] - 1);
            quickSort(array, p[1] + 1, r);

        }
    }

    public static int[] partition(int[] array, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (array[l] < array[r]) {
                swap(array, ++less, l++);
            } else if (array[l] > array[r]) {
                swap(array, --more, l);
            } else {
                l++;
            }
        }

        swap(array, more, r);
        return new int[] { less + 1, more };
    }

    public static void swap (int[] array, int i, int j) {
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }

}
