package com.sean.刷题.深度优先搜索;

import com.sean.刷题.动态规划._122_买卖股票的最佳时机II;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * _12_路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明:  叶子节点是指没有子节点的节点。
 *
 * 示例:  
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 *
 * 链接：https://leetcode-cn.com/problems/path-sum
 *
 * @author chenxu
 * @summary _12_路径总和
 * @since 2020-08-20 13:23
 */
public class _12_路径总和 {

    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum1(root.left, sum - root.val) || hasPathSum1(root.right, sum - root.val);
    }


    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        List<Integer> list = new ArrayList<>();

        LinkedList<TreeNode> nodeStack = new LinkedList<>();
        LinkedList<Integer> numStack = new LinkedList<>();
        nodeStack.offer(root);
        numStack.offer(root.val);
        TreeNode node;
        Integer num;
        while (!nodeStack.isEmpty()) {
            node = nodeStack.pollLast();
            num = numStack.pollLast();
            if (node.left == null && node.right == null) {
                list.add(num);
            }
            if (node.left != null) {
                nodeStack.offer(node.left);
                numStack.offer(num + node.left.val);
            }

            if (node.right != null) {
                nodeStack.offer(node.right);
                numStack.offer(num + node.right.val);
            }
        }
        return list.contains(sum);
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(8);
//
//        root.left.left = new TreeNode(11);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);
//
//        root.right.left = new TreeNode(13);
//        root.right.right = new TreeNode(4);
//        root.right.right.right = new TreeNode(1);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        _12_路径总和 test = new _12_路径总和();
        System.out.println(test.hasPathSum(root, 22));
//        System.out.println(test.hasPathSum(root, 2));
    }
}
