package com.sean.刷题.数组;

/**
 * _面试题_16_16_部分排序
 * 给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
 *
 * 示例：
 *
 * 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
 * 输出： [3,9]
 * 提示：
 *
 * 0 <= len(array) <= 1000000
 *
 * 链接：https://leetcode-cn.com/problems/sub-sort-lcci
 *
 * @author chenxu
 * @summary _面试题_16_16_部分排序
 * @since 2020-11-06 16:42
 */
public class _面试题_16_16_部分排序 {

    public int[] subSort(int[] array) {
        if (array == null || array.length == 0) return new int[] {-1, -1};

        // 从左扫描到右寻找逆序对(正序： 逐渐变大)
        int max = array[0];
        // 用来记录最右的那个逆序对位置
        int r = -1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= max) {
                max = array[i];
            } else {
                r = i;
            }
        }

        // 提前结束
        if (r == -1) return new int[] { -1, -1};

        // 从右扫描到左寻找逆序对(逆序: 逐渐变小)
        int min = array[array.length - 1];
        // 用来记录最左的那个逆序对位置
        int l = -1;
        for (int j = array.length - 2; j >= 0; j--) {
            if (array[j] <= min) {
                min = array[j];
            } else {
                l = j;
            }
        }
        return new int[] {l, r};
    }
}
