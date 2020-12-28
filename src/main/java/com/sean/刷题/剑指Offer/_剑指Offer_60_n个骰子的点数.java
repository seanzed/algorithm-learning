package com.sean.刷题.剑指Offer;

/**
 * _剑指Offer_60_n个骰子的点数 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *
 *  
 *
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 1 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667] 示例 2:
 *
 * 输入: 2 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 *  
 *
 * 限制：
 *
 * 1 <= n <= 11
 *
 * 链接：https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof
 *
 * @author chenxu
 * @summary _剑指Offer_60_n个骰子的点数
 * @since 2020-09-09 12:59
 */
public class _剑指Offer_60_n个骰子的点数 {

    public double[] twoSum(int n) {
        double pre[] = {1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d};
        for (int i = 2; i <= n; i++) {
            double tmp[] = new double[5 * i + 1];
            for (int j = 0; j < pre.length; j++)
                for (int x = 0; x < 6; x++) {
                    tmp[j + x] += pre[j] / 6;
                }
            pre = tmp;
        }
        return pre;
    }

    public double[] twoSum1(int n) {
        //表示i个骰子掷出s点的次数
        int dp[][] = new int[n + 1][6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            //表示一个骰子掷出i点的次数为1
            dp[1][i] = 1;
        }

        //表示骰子的个数
        for (int i = 2; i <= n; i++) {
            //表示可能会出现的点数之和
            for (int s = i; s <= 6 * i; s++) {
                //表示当前这个骰子可能掷出的点数
                for (int j = 1; j <= 6; j++) {
                    //当总数还没有j大时，就不存在这种情况
                    if (s - j < i - 1) {
                        break;
                    }

                    //当前n个骰子出现的点数之和等于前一次出现的点数之和加上这一次出现的点数
                    dp[i][s] += dp[i - 1][s - j];
                }
            }
        }

        //掷出n次点数出现的所有情况
        double total = Math.pow((double) 6, (double) n);

        //因为最大就只会出现5*n+1中点数
        double[] ans = new double[5 * n + 1];
        for (int i = n; i <= 6 * n; i++) {
            //第i小的点数出现的概率
            ans[i - n] = ((double) dp[n][i]) / total;
        }
        return ans;
    }
}
