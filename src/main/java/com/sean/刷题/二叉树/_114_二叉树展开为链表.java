package com.sean.刷题.二叉树;

/**
 * description 给定一个二叉树，原地将它展开为链表。
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 *
 * @author chenxu 2020/05/07 00:29
 */
public class _114_二叉树展开为链表 {

    public void flatten(TreeNode root) {
        if (root == null) return;

        // 将根节点的左子树变成链表
        flatten(root.left);
        // 将根节点的右子树变成链表
        flatten(root.right);

        TreeNode tmp = root.right;

        // 把树的右边换成左边链表
        root.right = root.left;

        root.left = null;
        // 找到最右边的节点
        while (root.right != null) {
            root = root.right;
        }

        root.right = tmp;
    }
}
