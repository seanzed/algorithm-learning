package com.sean.刷题.栈;

import java.util.Stack;

/**
 * _739_每日温度
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用  0 来代替。
 *
 * 例如，给定一个列表  temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是  [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是  [1, 30000]。每个气温的值的均为华氏度，都是在  [30, 100]  范围内的整数。
 *
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 *
 * @author chenxu
 * @summary _739_每日温度
 * @since 2020-11-13 17:47
 */
public class _739_每日温度 {

    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) return null;
        int[] values = new int[T.length];
        for (int i = T.length - 2; i >= 0; i--) {
            int j = i + 1;
            while (true) {
                if (T[i] < T[j]) {
                    values[i] = j - i;
                    break;
                } else if (values[j] == 0) {
                    values[i] = 0;
                    break;
                }
                // 当T[i] == T[j]的时候
                j = j + values[j];
            }
        }
        return values;
    }

    public int[] dailyTemperatures1(int[] T) {
        if (T == null || T.length == 0) return null;
        int[] values = new int[T.length];

        for (int i = T.length - 2; i >= 0; i--) {
            int j = i + 1;
            // 这里应该要写大于， 不要写小于
            while (true) {
               if (T[i] < T[j]) {
                   values[i] = j - i;
                   break;
               } else if (values[j] == 0) {
                   values[i] = 0;
                   break;
               } else if (T[i] == T[j]) {
                   values[i] = values[j] + j - i;
                   break;
               } else {
                   j = j + values[j];
               }
            }
        }
        return values;
    }

    public int[] dailyTemperatures2(int[] T) {
        if (T == null || T.length == 0) return null;
        int[] result = new int[T.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < T.length; i++) {
            // 这里应该要写大于， 不要写小于
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                result[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}
