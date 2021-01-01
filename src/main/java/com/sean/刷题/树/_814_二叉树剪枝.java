package com.sean.刷题.树;

/**
 * _814_二叉树剪枝
 * 给定二叉树根结点  root  ，此外树的每个结点的值要么是 0，要么是 1。
 *
 * 返回移除了所有不包含 1 的子树的原二叉树。
 *
 * ( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
 *
 * 示例1:
 * 输入: [1,null,0,0,1]
 * 输出: [1,null,0,null,1]
 *
 * 解释:
 * 只有红色节点满足条件“所有不包含 1 的子树”。
 * 右图为返回的答案。
 *
 * 链接：https://leetcode-cn.com/problems/binary-tree-pruning
 *
 * @author chenxu
 * @summary _814_二叉树剪枝
 * @since 2020-08-22 17:37
 */
public class _814_二叉树剪枝 {

    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }

    private boolean containsOne(TreeNode node) {
        if (node == null) return false;
        boolean left = containsOne(node.left);
        boolean right = containsOne(node.right);
        if (!left) node.left = null;
        if (!right) node.right = null;
        return node.val == 1 || left || right;
    }
}
