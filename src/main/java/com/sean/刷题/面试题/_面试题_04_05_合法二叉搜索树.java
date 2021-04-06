package com.sean.刷题.面试题;

import com.sean.刷题.二叉树.TreeNode;

/**
 * _面试题_04_05_合法二叉搜索树
 *
 * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
 *
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 链接：https://leetcode-cn.com/problems/legal-binary-search-tree-lcci
 *
 * @author chenxu
 * @summary _面试题_04_05_合法二叉搜索树
 * @since 2021-03-22 11:32
 */
public class _面试题_04_05_合法二叉搜索树 {

    private long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        if (!isValidBST(root.left)) {
            return false;
        }

        if (root.val <= pre) {
            return false;
        }

        pre = root.val;

        return isValidBST(root.right);
    }
}

