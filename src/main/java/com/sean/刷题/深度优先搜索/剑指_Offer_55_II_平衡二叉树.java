package com.sean.刷题.深度优先搜索;

/**
 * 剑指_Offer_55_II_平衡二叉树
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 *   
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 *
 * 链接：https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof
 *
 * @author chenxu
 * @summary 剑指_Offer_55_II_平衡二叉树
 * @since 2020-08-20 13:11
 */
public class 剑指_Offer_55_II_平衡二叉树 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return (Math.abs(maxDepth(root.left) - maxDepth(root.right)) < 2) && isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
