package com.sean.刷题.深度优先搜索;

import java.util.LinkedList;
import java.util.Stack;

/**
 * _513_找树左下角的值
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 *
 * 示例 1:
 *
 * 输入:
 *
 *     2
 *    / \
 *   1   3
 *
 * 输出:
 * 1
 *
 *
 * 示例 2:
 *
 * 输入:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * 输出:
 * 7
 *
 * 链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
 *
 * @author chenxu
 * @summary _513_找树左下角的值
 * @since 2020-08-20 20:37
 */
public class _513_找树左下角的值 {

    public int findBottomLeftValue(TreeNode root) {

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode node;
        int res = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                if (i == 0) {
                    res = node.val;
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return res;
    }
}
