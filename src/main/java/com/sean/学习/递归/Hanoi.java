package com.sean.学习.递归;

/**
 * 汉诺塔
 *
 * @author chenxu
 * @summary 汉诺塔
 * @Copyright (c) 2020, Lianjia Group All Rights Reserved.
 * @since 2020-08-07 11:04
 */
public class Hanoi {

    public static void main(String[] args) {
        new Hanoi().hanoi(10, "A", "B", "C");
    }

    /**
     * 将n个碟子从p1 挪动到p3
     *
     * @param   n
     * @param   p1
     * @param   p2
     * @param   p3
     * @summary 将n个碟子从p1 挪动到p3
     * @author chenxu
     * @version v1
     * @since 2020-08-07 11:10:22
     */
    void hanoi(int n, String p1, String p2, String p3) {
        if (n == 1) {
            move(n, p1, p3);
            return;
        }
        hanoi(n - 1, p1, p3, p2);
        move(n, p1, p3);
        hanoi(n - 1, p2, p1, p3);
    }

    /**
     * 将no 号从from移动到to
     *
     * @param   no
     * @param   from
     * @param   to
     * @summary 将no 号从from移动到to
     * @author chenxu
     * @version v1
     * @since 2020-08-07 11:11:03
     */
    void move(int no, String from, String to) {
        System.out.println("将" + no + "号盘子从" + from + "移动到" + to);
    }
}
