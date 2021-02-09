package com.sean.刷题.递归;

/**
 * _687_最长同值路径 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 *
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 *
 * 示例 1:
 *
 * 输入:
 *
 * 5 / \ 4   5 / \   \ 1   1   5 输出:
 *
 * 2 示例 2:
 *
 * 输入:
 *
 * 1 / \ 4   5 / \   \ 4   4   5 输出:
 *
 * 2 注意: 给定的二叉树不超过10000个结点。  树的高度不超过1000。
 *
 * 链接：https://leetcode-cn.com/problems/longest-univalue-path
 *
 * @author chenxu
 * @summary _687_最长同值路径
 * @since 2020-08-15 19:43
 */
public class _687_最长同值路径 {

    int max = Integer.MIN_VALUE;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        postOrder(root, root.val);
        return max;
    }

    private int postOrder(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        int left = postOrder(root.left, root.val);
        int right = postOrder(root.right, root.val);
        max = Math.max(max, left + right);
        if (root.val == val) {
            return Math.max(left, right) + 1;
        }
        return 0;
    }
}
