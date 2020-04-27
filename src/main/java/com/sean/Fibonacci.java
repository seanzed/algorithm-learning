package com.sean;

/**
 * description 斐波那契数列
 *
 * @author chenxu 2020/04/27 23:17
 */
public class Fibonacci {

    public static void main(String[] args) {
        int fib = fib2(45);
        System.out.println(fib);
    }

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }

        return fib(n -1 ) + fib(n -2);
    }

    public static int fib2(int n) {
        if (n == 1) return n;

        int first = 0;
        int second = 1;
        for (int i = 0; i < n - 1; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }

}
