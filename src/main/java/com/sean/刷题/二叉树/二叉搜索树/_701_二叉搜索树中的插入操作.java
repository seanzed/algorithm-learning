package com.sean.刷题.二叉树.二叉搜索树;

import com.sean.刷题.二叉树.TreeNode;

/**
 * description 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 保证原始二叉搜索树中不存在新值。
 *
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 *
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 *
 * @author chenxu 2020/05/07 00:39
 */
public class _701_二叉搜索树中的插入操作 {

    /**
     * 递归版本
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (root.val < val) {
            if (root.right != null) {
                insertIntoBST(root.right, val);
            } else {
                root.right = new TreeNode(val);
            }
        }
        if (root.val > val) {
            if (root.left != null) {
                insertIntoBST(root.left, val);
            } else {
                root.left = new TreeNode(val);
            }
        }
        return root;
    }
}
