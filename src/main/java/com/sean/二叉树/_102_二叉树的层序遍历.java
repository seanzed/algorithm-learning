package com.sean.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * description 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 * @author chenxu 2020/05/07 00:21
 */
public class _102_二叉树的层序遍历 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 创建数组来接收出队的节点，存放的是每层节点
            List<Integer> levelResult = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                // 定义 node 接收出队结点，然后加入数组 tmp 中
                TreeNode node = queue.poll();
                levelResult.add(node.val);
                // 如果有左右孩子，就依次入队、出队、进数组
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(levelResult);

        }
        return result;
    }
}
