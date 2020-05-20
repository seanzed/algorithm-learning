package com.sean.刷题.二叉树;

/**
 * description 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 * @author chenxu 2020/05/07 00:22
 */
public class _104_二叉树的最大深度 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}
