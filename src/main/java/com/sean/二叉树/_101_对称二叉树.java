package com.sean.二叉树;

/**
 * description 给定一个二叉树，检查它是否是镜像对称的。
 * https://leetcode-cn.com/problems/symmetric-tree/
 *
 * @author chenxu 2020/05/07 00:33
 */
public class _101_对称二叉树 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
