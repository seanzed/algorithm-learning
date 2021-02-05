package com.sean.刷题.二叉树.二叉搜索树;

import com.sean.刷题.二叉树.TreeNode;

/**
 * description 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 *
 * @author chenxu 2020/05/07 00:39
 */
public class _700_二叉搜索树中的搜索 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;

        TreeNode node = root;
        while (node != null) {
            if (node.val == val) {
                return node;
            } else if (node.val > val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }
}
