package com.sean.刷题.动态规划;

/**
 * _309_最佳买卖股票时机含冷冻期
 * 给定一个整数数组，其中第  i  个元素代表了第  i  天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 *
 * @author chenxu
 * @summary _309_最佳买卖股票时机含冷冻期
 * @since 2020-08-29 08:49
 */
public class _309_最佳买卖股票时机含冷冻期 {

    /**
     * 第一步：状态定义
     * dp[i][j] 表示 [0, i] 区间内，在下标为 i 这一天状态为 j 时的最大收益。
     *
     * 这里 j 取三个值：
     *
     * 0 表示不持股；
     * 1 表示持股；
     * 2 表示处在冷冻期。
     *
     * 第二步：状态转移方程
     * 不持股可以由这两个状态转换而来：
     * 昨天不持股，今天什么都不操作，仍然不持股；
     * 昨天持股，今天卖了一股。
     * 持股可以由这两个状态转换而来：
     * 昨天持股，今天什么都不操作，仍然持股；
     * 昨天处在冷冻期，今天买了一股；
     * 处在冷冻期只可以由不持股转换而来，因为题目中说，刚刚把股票卖了，需要冷冻 1 天。
     * 上面的分析可以用下面这张图表示：
     *
     *
     *
     * 与之前股票问题的不同之处只在于：从不持股状态不能直接到持股状态，得经过一个冷冻期，才能到持股状态。
     *
     * 第三步：思考初始化
     * 在第 0 天，不持股的初始化值为 0，持股的初始化值为 -prices[0]（表示购买了一股），虽然不处于冷冻期，但是初始化的值可以为 0。
     *
     * 第四步：思考输出
     * 每一天都由前面几天的状态转换而来，最优值在最后一天。取不持股和冷冻期的最大者。
     *
     *
     * @param   prices
     * @return  {@link int}
     * @summary
     * @author chenxu
     * @version v1
     * @since 2020-08-29 08:58:04
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        int length = prices.length;

        int[][] dp = new int[prices.length][3];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;

        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] - prices[i]);
            dp[i][2] = dp[i - 1][0];
        }

        return Math.max(dp[length - 1][0], dp[length - 1][2]);
    }
}
