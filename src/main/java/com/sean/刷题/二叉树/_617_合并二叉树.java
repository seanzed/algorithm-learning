package com.sean.刷题.二叉树;

/**
 * description 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为  NULL 的节点将直接作为新二叉树的节点。
 *
 * https://leetcode-cn.com/problems/merge-two-binary-trees
 *
 * @author chenxu 2020/05/26 23:57
 */
public class _617_合并二叉树 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2 == null ? null : t2;
        // t1不为空
        if (t2 == null) return t1;

        // t1和t1都不为空
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
