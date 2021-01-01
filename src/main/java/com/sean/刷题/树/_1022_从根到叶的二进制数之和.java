package com.sean.刷题.树;

/**
 * _1022_从根到叶的二进制数之和 给出一棵二叉树，其上每个结点的值都是  0  或  1  。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为  0 -> 1 -> 1 ->
 * 0 -> 1，那么它表示二进制数  01101，也就是  13  。
 *
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 *
 * 以  10^9 + 7  为模，返回这些数字之和。
 *
 *
 *
 * 示例：
 *
 *
 *
 * 输入：[1,0,1,0,1,0,1] 输出：22 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 *
 * 提示：
 *
 * 树中的结点数介于 1 和 1000 之间。 node.val 为  0 或  1  。
 *
 * 链接：https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers
 *
 * @author chenxu
 * @summary _1022_从根到叶的二进制数之和
 * @since 2020-08-20 21:38
 */
public class _1022_从根到叶的二进制数之和 {

    int ans = 0;    // 存放结果
    int mod = 1000000000 + 7;   // 用作取模

    public int sumRootToLeaf(TreeNode root) {
        helper(root, 0);
        return ans % mod;
    }

    public void helper(TreeNode root, int sum) {
        if (root != null) {
            sum = sum * 2 + root.val;
            if (root.left == null && root.right == null) {
                ans += sum;     // 到达叶子节点，得到一个和，加到结果上
            } else {    // 没有到达叶子节点，继续递归
                helper(root.left, sum);
                helper(root.right, sum);
            }
        }
    }


}
