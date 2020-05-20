package com.sean.刷题.排序;

/**
 * description 二分法查找
 *
 * @author chenxu 2020/04/06 20:51
 */
public class Code04_BSExist {

    public static boolean exist(int[] array, int num) {
        if (array == null || array.length == 0) {
            return false;
        }

        int L = 0;
        int R = array.length - 1;
        int mid = 0;

        while (L < R) {
            mid = L + ((R = L) >> 1);
            if (array[mid] == num) {
                return true;
            } else if (array[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        return array[mid] == num;
    }

}
