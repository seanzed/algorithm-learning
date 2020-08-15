package com.sean.刷题.动态规划;

/**
 * _338_比特位计数
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 *
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 *
 * 链接：https://leetcode-cn.com/problems/counting-bits
 *
 * @author chenxu
 * @summary _338_比特位计数
 * @since 2020-08-15 12:03
 */
public class _338_比特位计数 {

    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for(int i = 0; i <= num; i++) {
            ans[i] = popCount(i);
        }
        return ans;
    }

    private int popCount(int x) {
        int count;
        for (count = 0; x != 0; count++) {
            x &= x - 1;
        }
        return count;
    }

    public int[] countBits1(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++)
            ans[i] = ans[i >> 1] + (i & 1); // x / 2 is x >> 1 and x % 2 is x & 1
        return ans;
    }

    public static void main(String[] args) {
        _338_比特位计数 test = new _338_比特位计数();
        int[] ints = test.countBits(5);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
