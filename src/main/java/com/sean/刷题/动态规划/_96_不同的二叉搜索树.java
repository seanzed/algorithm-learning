package com.sean.刷题.动态规划;

/**
 * _96_不同的二叉搜索树 给定一个整数 n，求以  1 ...  n  为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3 输出: 5 解释: 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 * 1         3     3      2      1 \       /     /      / \      \ 3     2     1      1   3      2 /
 * /       \                 \ 2     1         2                 3
 *
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 *
 * @author chenxu
 * @summary _96_不同的二叉搜索树
 * @since 2020-08-15 17:00
 */
public class _96_不同的二叉搜索树 {

    /**
     * n = 1时，有1种 n = 2时，有2种 n = 3时，有5种 C0 = 1 Cn+1 = (2 * (2n + 1) / (n + 2) ) * Cn
     *
     * @return {@link int}
     * @summary
     * @author chenxu
     * @version v1
     * @since 2020-08-15 17:01:26
     */
    public int numTrees(int n) {
        // 提示：我们在这里需要用 long 类型防止计算过程中的溢出
        long C = 1;
        for (int i = 0; i < n; i++) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }

    public int numTrees1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

}
