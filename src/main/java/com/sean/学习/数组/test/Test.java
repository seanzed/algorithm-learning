package com.sean.学习.数组.test;

/**
 * Test
 *
 * @author chenxu
 * @summary Test
 * @Copyright (c) 2020, Lianjia Group All Rights Reserved.
 * @since 2020-08-14 23:39
 */
public class Test {

    public static void main(String[] args) {
        ArrayList_optimize<Integer> list = new ArrayList_optimize<>();
        list.add(0, 1);
        list.add(0, 2);
        list.add(0, 3);
        list.add(0, 4);

        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
