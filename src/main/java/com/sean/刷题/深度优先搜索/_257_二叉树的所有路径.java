package com.sean.刷题.深度优先搜索;

import java.util.LinkedList;
import java.util.List;

/**
 * _257_二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 *
 * @author chenxu
 * @summary _257_二叉树的所有路径
 * @Copyright (c) 2020, Lianjia Group All Rights Reserved.
 * @since 2020-08-20 09:03
 */
public class _257_二叉树的所有路径 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new LinkedList<>();

        if (root == null) return paths;

        LinkedList<TreeNode> nodeStack = new LinkedList<>();
        LinkedList<String> pathStack = new LinkedList<>();
        nodeStack.offer(root);
        pathStack.offer(Integer.toString(root.val));

        TreeNode node;
        String path;
        while (!nodeStack.isEmpty()) {
            node = nodeStack.pollLast();
            path = pathStack.pollLast();
            if (node.left == null && node.right == null) {
                paths.add(path);
            }

            if (node.left != null) {
                nodeStack.offer(node.left);
                pathStack.offer(path + "->" + node.left.val);
            }
            if (node.right != null) {
                nodeStack.offer(node.right);
                pathStack.offer(path + "->" + node.right.val);
            }
        }
        return paths;
    }
}
