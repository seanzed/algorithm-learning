package com.sean.刷题.剑指Offer;

import java.util.LinkedList;
import java.util.List;

/**
 * _剑指Offer_34_二叉树中和为某一值的路径 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 *
 *
 * 示例: 给定如下二叉树，以及目标和  sum = 22，
 *
 * 5 / \ 4   8 /   / \ 11  13  4 /  \    / \ 7    2  5   1 返回:
 *
 * [ [5,4,11,2], [5,8,4,5] ]
 *
 * 提示：回溯法
 *
 * 节点总数 <= 10000
 *
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 *
 * @author chenxu
 * @summary _剑指Offer_34_二叉树中和为某一值的路径
 * @since 2020-09-14 22:57
 */
public class _剑指Offer_34_二叉树中和为某一值的路径 {

    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }

    void recur(TreeNode root, int tar) {
        if (root == null) return;
        path.add(root.val);
        tar -= root.val;
        if (tar == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList(path));
        }
        recur(root.left, tar);
        recur(root.right, tar);
        // 删除最后一个节点
        path.removeLast();
    }
}
