package com.sean.刷题.二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * description 二叉树前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 *
 * @author chenxu 2020/05/07 00:18
 */
public class _144_二叉树的前序遍历 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);
        return result;
    }

    public void preorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) return;

        result.add(root.val);
        preorderTraversal(root.left, result);
        preorderTraversal(root.right, result);
    }

    public List<Integer> preorderTaversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }
}
