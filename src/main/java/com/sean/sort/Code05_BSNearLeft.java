package com.sean.sort;

/**
 * description 二分法查找变种，在arr上，找满足>=value的最左位置
 *
 * @author chenxu 2020/04/06 21:04
 */
public class Code05_BSNearLeft {

    public static int nearIndex(int[] arr, int value) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int l = 0;
        int r = arr.length - 1;
        int index = 0;
        while (l < r) {
            int mid = l + ((r - l) >> 1);

            if (arr[mid] >= value) {
                index = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return index;
    }


}
