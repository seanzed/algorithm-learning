package com.sean.刷题.二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * description 二叉树中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *
 * @author chenxu 2020/05/07 00:18
 */
public class _94_二叉树的中序遍历 {

    /**
     * 中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);

        return result;
    }

    public void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) return;

        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                result.add(node.val);
                root = node.right;
            }
        }

        return result;
    }

}
