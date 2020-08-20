package com.sean.刷题.深度优先搜索;

/**
 * _111_二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 *
 * @author chenxu
 * @summary _111_二叉树的最小深度
 * @since 2020-08-20 13:24
 */
public class _111_二叉树的最小深度 {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        //左子树的最小深度
        int left = minDepth(root.left);
        //右子树的最小深度
        int right = minDepth(root.right);
        //如果left和right都为0，我们返回1即可，
        //如果left和right只有一个为0，说明他只有一个子结点，我们只需要返回它另一个子节点的最小深度+1即可。
        //如果left和right都不为0，说明他有两个子节点，我们只需要返回最小深度的+1即可。
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }
}
