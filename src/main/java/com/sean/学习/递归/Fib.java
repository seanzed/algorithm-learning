package com.sean.学习.递归;

import com.sean.学习.tools.Times;

/**
 * 斐波那契数列
 *
 * @author chenxu
 * @summary 斐波那契数列
 * @since 2020-08-07 10:11
 */
public class Fib {

    public static void main(String[] args) {
        Fib fib = new Fib();
        int n = 40;
        Times.test("fib0", () -> {
            System.out.println(fib.fib0(n));
        });
        Times.test("fib1", () -> {
            System.out.println(fib.fib1(n));
        });
        Times.test("fib2", () -> {
            System.out.println(fib.fib2(n));
        });
        Times.test("fib3", () -> {
            System.out.println(fib.fib3(n));
        });

        Times.test("fib4", () -> {
            System.out.println(fib.fib4(n));
        });

        Times.test("fib5", () -> {
            System.out.println(fib.fib5(n));
        });
    }

    /**
     * 斐波那契数列第一种方法实现
     *
     * @param   n
     * @return  {@link int}
     * @summary 斐波那契数列第一种方法实现
     * @author chenxu
     * @since 2020-08-07 10:14:05
     */
    int fib0(int n) {
        if (n <= 2) return 1;
        return fib0(n - 1) + fib0(n - 2);
    }

    /**
     * 斐波那契数列第二种方法实现---递归记忆化搜索
     *
     * @param   n
     * @return  {@link int}
     * @summary  斐波那契数列第二种方法实现---递归记忆化搜索
     * @author chenxu
     * @version v1
     * @since 2020-08-07 10:16:52
     */
    int fib1(int n) {
        if (n <= 2) return 1;
        int[] array = new int[n + 1];
        array[1] = array[2] = 1;
        return fib1(n , array);
    }

    int fib1(int n , int[] array) {
        if (array[n] == 0) {
            array[n] = fib1(n - 1, array) + fib1(n - 2, array);
        }

        return array[n];
    }

    /**
     * 斐波那契数列第三种方法实现----循环记忆化搜索
     *
     * @param   n
     * @return  {@link int}
     * @summary 斐波那契数列第三种方法实现----循环记忆化搜索
     * @author chenxu
     * @version v1
     * @since 2020-08-07 10:19:32
     */
    int fib2(int n) {
        if (n <= 2) return 1;
        int[] array = new int[n + 1];
        array[1] = array[2] = 1;
        for (int i = 3; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    int fib3(int n) {
        if (n <= 2) return 1;
        int[] array = new int[2];
        array[0] = array[1] = 1;
        for (int i = 3; i <= n; i++) {
            array[i % 2] = array[(i - 1) % 2] + array[(i - 2) % 2];
        }

        return array[n % 2];
    }

    int fib4(int n) {
        if (n <= 2) return 1;
        int[] array = new int[2];
        array[0] = array[1] = 1;
        for (int i = 3; i <= n; i++) {
            array[i & 1] = array[(i - 1) & 1] + array[(i - 2) & 1];
        }
        return array[n & 1];
    }

    int fib5(int n) {
        if (n <= 2) return 1;
        int first = 1;
        int second = 1;
        for (int i = 3; i <= n; i++) {
            second = first + second;
            first = second - first;
        }
        return second;
    }
}
