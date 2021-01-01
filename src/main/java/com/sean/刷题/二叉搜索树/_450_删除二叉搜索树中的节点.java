package com.sean.刷题.二叉搜索树;

/**
 * description 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的  key  对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 *
 * https://leetcode-cn.com/problems/delete-node-in-a-bst
 * @author chenxu 2020/05/07 00:37
 */
public class _450_删除二叉搜索树中的节点 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            } else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }

        return root;
    }

    /**
     * 前驱节点
     * @param node
     * @return
     */
    private int successor(TreeNode node) {
        if (node == null) return -1;
        node = node.right;
        if (node != null) {
            while (node.left != null) {
                node = node.left;
            }
        }
        return node.val;
    }

    private int predecessor(TreeNode node) {
        if (node == null) return -1;
        node = node.left;
        if (node != null) {
            while(node.right != null) {
                node = node.right;
            }
        }
        return node.val;
    }
}
