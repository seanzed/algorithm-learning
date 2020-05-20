package com.sean.刷题.二叉搜索树;

import com.sean.学习.栈.Stack;

/**
 * description 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 *
 * 二叉搜索树保证具有唯一的值。
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 *
 *
 * @author chenxu 2020/05/07 08:33
 */
public class _938_二叉搜索树的范围和 {

    int sum = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        inorder(root, L, R);
        return sum;
    }

    private void inorder(TreeNode node, int L , int R) {
        if (node == null) return;

        inorder(node.left, L, R);

        while (node.val > L && node.val < R) {
            sum += node.val;
        }

        if (node.val > R) {
            return;
        }

        inorder(node.right, L, R);
    }

    public int rangeSumBST1(TreeNode root, int L, int R) {
        if (root == null) return 0;

        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                if (node.val >= L && node.val <= R) {
                    sum += node.val;
                }

                if (node.val > R) {
                    break;
                }
                root = node.right;
            }

        }

        return sum;
    }

    public int rangeSumBST2(TreeNode root, int L, int R) {
        if (root == null) return 0;
        if (root.val < L) return rangeSumBST(root.right, L, R);
        if (root.val > R) return rangeSumBST(root.left, L, R);
        return root.val + rangeSumBST(root.right, L, R) + rangeSumBST(root.left, L, R);
    }

}
