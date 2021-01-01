package com.sean.刷题.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * _199_二叉树的右视图
 *
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入:  [1,2,3,null,5,null,4]
 * 输出:  [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 *
 * @author chenxu
 * @summary _199_二叉树的右视图
 * @since 2020-12-28 17:40
 */
public class _199_二叉树的右视图 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

                // 将最后一个节点放入数组
                if (i == size - 1) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }

    private List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView1(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if (depth == res.size()) {
            res.add(root.val);
        } else {
            res.set(depth, root.val);
        }

        depth++;
        dfs(root.left, depth);
        dfs(root.right, depth);
    }
}
