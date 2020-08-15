package com.sean.刷题.动态规划;

/**
 * _877_石子游戏 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
 *
 * 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
 *
 * 亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
 *
 * 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
 *
 *  
 *
 * 示例：
 *
 * 输入：[5,3,4,5] 输出：true 解释： 亚历克斯先开始，只能拿前 5 颗或后 5 颗石子 。 假设他取了前 5 颗，这一行就变成了 [3,4,5] 。 如果李拿走前 3
 * 颗，那么剩下的是 [4,5]，亚历克斯拿走后 5 颗赢得 10 分。 如果李拿走后 5 颗，那么剩下的是 [3,4]，亚历克斯拿走后 4 颗赢得 9 分。 这表明，取前 5
 * 颗石子对亚历克斯来说是一个胜利的举动，所以我们返回 true 。  
 *
 * 提示：
 *
 * 2 <= piles.length <= 500 piles.length 是偶数。 1 <= piles[i] <= 500 sum(piles) 是奇数。
 *
 * 链接：https://leetcode-cn.com/problems/stone-game
 *
 * @author chenxu
 * @summary _877_石子游戏
 * @since 2020-08-15 13:08
 */
public class _877_石子游戏 {

    /**
     * 让我们改变游戏规则，使得每当李得分时，都会从亚历克斯的分数中扣除。
     *
     * 令 dp(i, j) 为亚历克斯可以获得的最大分数，其中剩下的堆中的石子数是 piles[i], piles[i+1], ..., piles[j]。
     *
     * 这在比分游戏中很自然：我们想知道游戏中每个位置的值。
     *
     * 我们可以根据 dp(i + 1，j) 和 dp(i，j-1) 来制定 dp(i，j) 的递归，我们可以使用动态编程以不重复这个递归中的工作。该方法可以输出正确的答案，因为状态形成一个DAG（有向无环图）。
     *
     * @param   piles
     * @return  {@link boolean}
     * @summary
     * @author chenxu
     * @version v1
     * @since 2020-08-15 16:59:00
     */
    public boolean stoneGame(int[] piles) {
        int N = piles.length;

        // dp[i+1][j+1] = the value of the game [piles[i], ..., piles[j]].
        int[][] dp = new int[N + 2][N + 2];
        for (int size = 1; size <= N; ++size)
            for (int i = 0; i + size <= N; ++i) {
                int j = i + size - 1;
                int parity = (j + i + N) % 2;  // j - i - N; but +x = -x (mod 2)
                if (parity == 1)
                    dp[i + 1][j + 1] = Math.max(piles[i] + dp[i + 2][j + 1], piles[j] + dp[i + 1][j]);
                else
                    dp[i + 1][j + 1] = Math.min(-piles[i] + dp[i + 2][j + 1], -piles[j] + dp[i + 1][j]);
            }

        return dp[1][N] > 0;
    }

    public boolean stoneGame1(int[] piles) {
        return true;
    }
}
