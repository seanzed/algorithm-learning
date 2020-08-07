package com.sean.学习.贪心;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * Pirate
 * 有一天，海盗们截获了一艘装满各种各样古董的货船，每一件古董都价值连城，一旦打碎就失去了它的价值 海盗船的载重量为 W，每件古董的重量为 𝑤i，海盗们该如何把尽可能多数量的古董装上海盗船?
 * 比如 W 为 30，𝑤i 分别为3,5,4,10,7,14,2,11
 * @author chenxu
 * @summary Pirate
 * @since 2020-08-07 13:21
 */
public class Pirate {

    public static void main(String[] args) {
        int[] weights = {3, 5, 4, 10, 7, 14, 2, 11};
        Arrays.sort(weights);
        int capacity= 30, weight = 0, count = 0;

        for (int i = 0; i < weights.length && weight < capacity; i++) {
            int newWeight = weight + weights[i];
            if (newWeight < capacity) {
                weight = newWeight;
                count++;
                System.out.println(weights[i]);
            }
        }

        System.out.println("一共选了" + count + "件古董");
    }
}
