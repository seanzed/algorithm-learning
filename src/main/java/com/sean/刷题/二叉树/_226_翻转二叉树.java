package com.sean.刷题.二叉树;

/**
 * description 翻转一棵二叉树。
 * https://leetcode-cn.com/problems/invert-binary-tree/
 *
 * @author chenxu 2020/05/06 20:16
 */
public class _226_翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
