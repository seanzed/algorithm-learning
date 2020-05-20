package com.sean.刷题.二叉搜索树;

/**
 * description 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 *
 * @author chenxu 2020/05/07 08:35
 */
public class _230_二叉搜索树中第K小的元素 {

    int ans;

    int index = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return ans;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null) return;

        inorder(node.left, k);
        index++;
        if (index == k) {
            ans = node.val;
            return;
        }

        inorder(node.right, k);
    }
}
