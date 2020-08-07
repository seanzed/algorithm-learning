package com.sean.刷题.数组;

/**
 * description 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 *
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 *
 * https://leetcode-cn.com/problems/sorted-merge-lcci
 *
 * @author chenxu 2020/05/26 23:39
 */
public class 面试题_合并排序的数组 {

    public void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while(i >=0 && j >=0 && k >=0) {
            if (A[i] > B[j]) {
                A[k--] = A[i--];
            } else {
                A[k--] = B[j--];
            }
        }

        if (j >= 0) {
            while (k >=0 && j>=0) {
                A[k--] = B[j--];
            }
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,0,0,0};
        int[] B = new int[]{2,5,6};
        面试题_合并排序的数组 test = new 面试题_合并排序的数组();
        test.merge(A, 3, B, 3);
        for (int i : A) {
            System.out.println(i);

        }
    }
}
