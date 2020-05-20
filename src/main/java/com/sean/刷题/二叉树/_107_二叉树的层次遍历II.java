package com.sean.刷题.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * description 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 *
 * @author chenxu 2020/05/07 00:23
 */
public class _107_二叉树的层次遍历II {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) return results;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        Stack<List<Integer>> stack = new Stack<>();

        while (!queue.isEmpty()) {
            List<Integer> levelResult = new ArrayList<>();

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelResult.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            stack.push(levelResult);
        }

        while(!stack.isEmpty()) {
            results.add(stack.pop());
        }

        return results;
    }

}
