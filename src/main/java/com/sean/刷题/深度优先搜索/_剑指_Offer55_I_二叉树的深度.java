package com.sean.刷题.深度优先搜索;

/**
 * _剑指_Offer55_I_二叉树的深度
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 例如：
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof
 *
 * @author chenxu
 * @summary _剑指_Offer55_I_二叉树的深度
 * @since 2020-08-20 08:50
 */
public class _剑指_Offer55_I_二叉树的深度 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
