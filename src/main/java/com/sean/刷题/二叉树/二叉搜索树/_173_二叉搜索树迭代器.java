package com.sean.刷题.二叉树.二叉搜索树;

import com.sean.刷题.二叉树.TreeNode;

import java.util.LinkedList;

/**
 * description 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 *
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 * https://leetcode-cn.com/problems/binary-search-tree-iterator/
 *
 *
 * @author chenxu 2020/05/07 08:36
 */
class BSTIterator {

    LinkedList<Integer> elements;

    public BSTIterator(TreeNode root) {
        elements = new LinkedList<>();
        inorder(root);
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        elements.add(node.val);
        inorder(node.right);
    }

    /** @return the next smallest number */
    public int next() {
        return elements.poll();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !elements.isEmpty();
    }
}