package com.sean.刷题.动态规划;

import java.util.Arrays;

/**
 * _646_最长数对链 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 *
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 *
 * 给定一个对数集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 *
 * 示例 :
 *
 * 输入: [[1,2], [2,3], [3,4]] 输出: 2 解释: 最长的数对链是 [1,2] -> [3,4] 注意：
 *
 * 给出数对的个数在 [1, 1000] 范围内。
 *
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-pair-chain
 *
 * @author chenxu
 * @summary _646_最长数对链
 * @since 2020-08-29 08:43
 */
public class _646_最长数对链 {

    public int findLongestChain(int[][] pairs) {
        // 1.定义排序：按照每个数对的start从小到大排序
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        // dp[i],以第i个数对结尾的链的最大长度
        int[] dp = new int[pairs.length];
        // 2.初始状态
        Arrays.fill(dp, 1);
        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    // 3.转移方程
                    // 若dp[j]+1较大 ,则说明在dp[j]之后接上一个dp[i]数对能使得链更长
                    // 若dp[i]较大,这说明在dp[j]之后接上一个dp[i]数对反而使数对更短
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        // 4.取dp数组中长度最大的
        int max = 0;
        for (int len : dp) {
            max = Math.max(len, max);
        }
        return max;
    }


    /**
     * 贪心算法
     *
     * @return {@link int}
     * @summary 贪心算法
     * @author chenxu
     * @version v1
     * @since 2020-08-29 08:46:40
     */
    public int findLongestChain1(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int cur = Integer.MIN_VALUE, ans = 0;
        for (int[] pair : pairs) {
            if (cur < pair[0]) {
                cur = pair[1];
                ans++;
            }
        }

        return ans;
    }
}
