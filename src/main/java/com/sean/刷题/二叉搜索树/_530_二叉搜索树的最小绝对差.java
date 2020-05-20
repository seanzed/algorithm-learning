package com.sean.刷题.二叉搜索树;

/**
 * description https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 *
 * @author chenxu 2020/05/07 00:41
 */
public class _530_二叉搜索树的最小绝对差 {

    TreeNode pre;
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);
        if (pre != null) {
            min = Math.min(min, node.val - pre.val);
        }
        pre = node;
        inorder(node.right);
    }
}
