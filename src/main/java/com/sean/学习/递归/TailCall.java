package com.sean.学习.递归;

/**
 * 尾调用
 *
 * @author chenxu
 * @summary 尾调用
 * @since 2020-08-07 11:14
 */
public class TailCall {

    public static void main(String[] args) {
        System.out.println(facttorial(10));
    }

    static int facttorial(int n) {
        return facttorial(n, 1);
    }

    static int facttorial(int n, int result) {
        if (n <= 1) return result;
        return facttorial(n - 1, result * n);
    }
}
