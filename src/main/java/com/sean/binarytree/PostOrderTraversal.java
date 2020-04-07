package com.sean.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * description 后序遍历
 *
 * @author chenxu 2020/04/07 22:36
 */
public class PostOrderTraversal {

    /**
     * 后序遍历递归版本
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    public void postOrder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.val);
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode current = null;
        while (!stack.isEmpty()) {
            current = stack.peek();
            if (current.left != null && root != current.left && root != current.right) {
                stack.push(current.left);
            } else if (current.right != null && root != current.right) {
                stack.push(current.right);
            } else {
                result.add(stack.pop().val);
                root = current;
            }
        }

        return result;

    }
}
