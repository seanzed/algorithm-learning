package com.sean.刷题.面试题;

import com.sean.刷题.二叉树.TreeNode;

/**
 * _面试题_04_06_后继者
 *
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 *
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 *
 * 示例 1:
 *
 * 输入: root = [2,1,3], p = 1
 *
 *   2
 *  / \
 * 1   3
 *
 * 输出: 2
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 *
 *       5
 *      / \
 *     3   6
 *    / \
 *   2   4
 *  /
 * 1
 *
 * 输出: null
 *
 * 链接：https://leetcode-cn.com/problems/successor-lcci
 *
 * @author chenxu
 * @summary _面试题_04_06_后继者
 * @since 2021-03-22 11:28
 */
public class _面试题_04_06_后继者 {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;

        TreeNode res = root;
        TreeNode tmp = root;
        while (tmp != null) {
            if (tmp.val <= p.val) {
                tmp = tmp.right;
            } else {
                res = tmp;
                tmp = tmp.left;
            }
        }
        return res.val <= p.val ? null : res;
    }
}
