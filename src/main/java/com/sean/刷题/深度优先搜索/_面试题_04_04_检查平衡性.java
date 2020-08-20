package com.sean.刷题.深度优先搜索;

/**
 * _面试题_04_04_检查平衡性
 * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 *
 *
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *       1
 *      / \
 *     2   2
 *    / \
 *   3   3
 *  / \
 * 4   4
 * 返回 false 。
 *
 * 链接：https://leetcode-cn.com/problems/check-balance-lcci
 *
 * @author chenxu
 * @summary _面试题_04_04_检查平衡性
 * @Copyright (c) 2020, Lianjia Group All Rights Reserved.
 * @since 2020-08-20 13:19
 */
public class _面试题_04_04_检查平衡性 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return (Math.abs(maxDepth(root.left) - maxDepth(root.right)) < 2) && isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
