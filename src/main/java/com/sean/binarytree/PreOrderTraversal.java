package com.sean.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * description 前序遍历
 *
 * @author chenxu 2020/04/07 22:19
 */
public class PreOrderTraversal {

    /**
     * 递归版本
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        process(root, result);
        return result;
    }

    public void process(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        process(node.left, result);
        process(node.right, result);
    }

    /**
     * 非递归版本
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            result.add(current.val);

            if (current.right != null) {
                stack.add(current.right);
            }

            if (current.left != null) {
                stack.add(current.left);
            }
        }

        return result;
    }

}
