package com.sean.刷题.二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * description 给定一个二叉树，返回它的 后序 遍历。
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 *
 * @author chenxu 2020/05/07 00:20
 */
public class _145_二叉树的后序遍历 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);

        return result;
    }

    public void postorderTraversal(TreeNode root, List<Integer> result) {
        if(root == null) return;

        postorderTraversal(root.left, result);
        postorderTraversal(root.right, result);
        result.add(root.val);
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {

        }

        return result;
    }
}
