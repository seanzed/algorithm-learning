package com.sean.学习.递归;

/**
 * 爬楼梯
 *
 * @author chenxu
 * @summary 爬楼梯
 * @Copyright (c) 2020, Lianjia Group All Rights Reserved.
 * @since 2020-08-07 10:27
 */
public class ClimbStairs {

    int climbStair(int n) {
        if (n <= 2) return n;
        return climbStair(n - 1) + climbStair(n -2);
    }

    int climbStair1(int n) {
        if (n <= 2) return n;
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n;i ++) {
            second = first + second;
            first = second - first;
        }

        return second;
    }
}
