package com.sean.刷题.动态规划;

/**
 * _123_买卖股票的最佳时机III 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成  两笔  交易。
 *
 * 注意:  你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例  1:
 *
 * 输入: [3,3,5,0,0,3,1,4] 输出: 6 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3
 * 。       随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。 示例 2:
 *
 * 输入: [1,2,3,4,5] 输出: 4 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
 *       注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。          因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。 示例 3:
 *
 * 输入: [7,6,4,3,1] 输出: 0 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 *
 * @author chenxu
 * @summary _123_买卖股票的最佳时机III
 * @since 2020-08-15 17:43
 */
public class _123_买卖股票的最佳时机III {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        //定义5种状态，并初始化第一天的状态
        int dp0 = 0;
        int dp1 = -prices[0];
        int dp2 = 0;
        int dp3 = -prices[0];
        int dp4 = 0;
        for (int i = 1; i < n; ++i) {
            //这里省略dp0，因为dp0每次都是从上一个dp0来的相当于每次都是0
            //处理第一次买入、第一次卖出
            dp1 = Math.max(dp1, dp0 - prices[i]);
            dp2 = Math.max(dp2, dp1 + prices[i]);
            //处理第二次买入、第二次卖出
            dp3 = Math.max(dp3, dp2 - prices[i]);
            dp4 = Math.max(dp4, dp3 + prices[i]);
        }
        //返回最大值
        return Math.max(0, Math.max(Math.max(dp1, dp2), Math.max(dp3, dp4)));
    }

    public int maxProfit1(int[] prices) {

        int minPrice1 = Integer.MAX_VALUE;
        int maxProfit1 = 0;
        int maxProfitAfterBuy = Integer.MIN_VALUE;
        int maxProfit2 = 0;
        for(int price : prices) {
            // 1.第一次最小购买价格
            minPrice1  = Math.min(minPrice1,  price);

            // 2.第一次卖出的最大利润
            maxProfit1 = Math.max(maxProfit1, price - minPrice1);

            // 3.第二次购买后的剩余净利润
            maxProfitAfterBuy  = Math.max(maxProfitAfterBuy,  maxProfit1 - price );

            // 4.第二次卖出后，总共获得的最大利润（第3步的净利润 + 第4步卖出的股票钱）
            maxProfit2 = Math.max(maxProfit2, price + maxProfitAfterBuy);
        }
        return maxProfit2;
    }
}
