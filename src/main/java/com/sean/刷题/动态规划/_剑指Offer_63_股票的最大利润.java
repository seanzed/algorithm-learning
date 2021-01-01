package com.sean.刷题.动态规划;

/**
 * _剑指Offer_63_股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *
 *   
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 链接：https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof
 *
 * @author chenxu
 * @summary _剑指Offer_63_股票的最大利润
 * @since 2020-08-15 18:10
 */
public class _剑指Offer_63_股票的最大利润 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        // 前面扫描过的最小价格
        int minPrice = prices[0];
        // 前面扫描过的最大利润
        int maxProfit = 0;
        // 扫描所有的价格
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        return maxProfit;
    }
}
