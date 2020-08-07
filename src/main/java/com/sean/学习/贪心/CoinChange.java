package com.sean.学习.贪心;

import java.util.Arrays;

/**
 * CoinChange
 *
 * @author chenxu
 * @summary CoinChange
 * @Copyright (c) 2020, Lianjia Group All Rights Reserved.
 * @since 2020-08-07 14:59
 */
public class CoinChange {

    public static void main(String[] args) {
//        coinChange1();

//        coinChange2(new Integer[]{25, 20,10, 5, 1}, 41);

        coinChange(new Integer[]{25, 20,10, 5, 1}, 41);
    }

    static void coinChange(Integer[] faces, int money) {
        Arrays.sort(faces);

        int coins = 0, idx = faces.length - 1;
        while (idx >= 0) {
            while (money >= faces[idx]) {
                System.out.println(faces[idx]);
                money -= faces[idx];
                coins++;
            }
            idx--;
        }
        System.out.println("需要" + coins + "枚硬币");
    }

    static void coinChange2(Integer[] faces, int money) {
        Arrays.sort(faces, (Integer f1, Integer f2) -> f2 - f1);
        int coins = 0, i = 0;
        while(i < faces.length) {
            if (money < faces[i]) {
                i++;
                continue;
            }

            System.out.println(faces[i]);
            money -= faces[i];
            coins++;
        }
        System.out.println("需要" + coins + "枚硬币");
    }

    static void coinChange1() {
        int[] faces = {25, 5, 10, 1};
        Arrays.sort(faces); // 1, 5, 10, 25

        int money = 41, coins = 0;
        for (int i = faces.length - 1; i >= 0; i--) {
            if (money < faces[i]) {
                continue;
            }

            System.out.println(faces[i]);
            money -= faces[i];
            coins++;
            i = faces.length;
        }

        System.out.println("需要" + coins + "枚硬币");
    }
}
