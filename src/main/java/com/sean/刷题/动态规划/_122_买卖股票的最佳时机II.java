package com.sean.刷题.动态规划;

/**
 * _122_买卖股票的最佳时机II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 *
 * @author chenxu
 * @summary _122_买卖股票的最佳时机II
 * @Copyright (c) 2020, Lianjia Group All Rights Reserved.
 * @since 2020-08-15 17:36
 */
public class _122_买卖股票的最佳时机II {

    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        _122_买卖股票的最佳时机II test = new _122_买卖股票的最佳时机II();
//        int[] prices = new int[] {7, 1, 5, 3, 6, 4};
        int[] prices = new int[] {1, 2, 3, 4, 5, 6};
        System.out.println(test.maxProfit(prices));
    }
}
