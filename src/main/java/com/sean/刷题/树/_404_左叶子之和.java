package com.sean.刷题.树;

/**
 * _404_左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 *
 * @author chenxu
 * @summary _404_左叶子之和
 * @since 2020-08-21 09:33
 */
public class _404_左叶子之和 {

    private int leftLeafSum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        levelOrder(root);
        return leftLeafSum;
    }

    private void levelOrder(TreeNode root) {
        if (root == null) return;

        if (root.left != null && root.left.left == null && root.left.right == null) {
            leftLeafSum += root.left.val;
        }

        levelOrder(root.left);
        levelOrder(root.right);
    }
}
