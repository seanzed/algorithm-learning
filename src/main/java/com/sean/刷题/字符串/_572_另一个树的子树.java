package com.sean.刷题.字符串;

import com.sean.binarytree.TreeNode;

/**
 * _572_另一个树的子树
 * 给定两个非空二叉树 s 和 t，检验  s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 示例 1:
 * 给定的树 s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 *
 * 示例 2:
 * 给定的树 s：
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 false。
 *
 * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree
 *
 * @author chenxu
 * @summary _572_另一个树的子树
 * @Copyright (c) 2020, Lianjia Group All Rights Reserved.
 * @since 2020-11-16 11:40
 */
public class _572_另一个树的子树 {





    public boolean isSubtree1(TreeNode s, TreeNode t) {
        if (t == null) return true;
        if (s == null) return false;
        return isSubtree1(s.left, t) || isSubtree1(s.right, t) || isSameTree(s, t);
    }

    public boolean isSameTree (TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
