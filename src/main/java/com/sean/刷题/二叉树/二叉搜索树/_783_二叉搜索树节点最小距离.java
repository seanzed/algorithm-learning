package com.sean.刷题.二叉树.二叉搜索树;

import com.sean.刷题.二叉树.TreeNode;

/**
 * description 给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。
 *
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 *
 * @author chenxu 2020/05/07 00:42
 */
public class _783_二叉搜索树节点最小距离 {

    TreeNode pre;
    int min = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
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
