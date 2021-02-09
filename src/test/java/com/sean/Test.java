package com.sean;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Test
 *
 * @author chenxu
 * @summary Test
 * @since 2020-09-09 16:02
 */
public class Test {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            if (value.equals(3)) {
                iterator.remove();
            }
        }

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
