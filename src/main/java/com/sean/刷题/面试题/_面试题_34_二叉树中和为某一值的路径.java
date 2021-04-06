package com.sean.刷题.面试题;

import com.sean.刷题.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * _面试题34_二叉树中和为某一值的路径
 *
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 *  
 *
 * 示例:
 * 给定如下二叉树，以及目标和 target = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *  
 *
 * 提示：
 *
 * 节点总数 <= 10000
 *
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 *
 * @author chenxu
 * @summary _面试题34_二叉树中和为某一值的路径
 * @since 2021-03-22 10:13
 */
public class _面试题_34_二叉树中和为某一值的路径 {

    private List<List<Integer>> res = new ArrayList<>();

    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return res;
    }

    private void dfs(TreeNode root, int target) {
        if (root == null) return;
        path.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }

        dfs(root.left, target);
        dfs(root.right, target);
        path.remove(path.size() - 1);
    }
}
