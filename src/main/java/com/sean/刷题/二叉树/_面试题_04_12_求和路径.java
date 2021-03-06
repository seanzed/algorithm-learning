package com.sean.刷题.二叉树;

/**
 * _面试题_04_12_求和路径
 *
 * 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
 *
 * 示例: 给定如下二叉树，以及目标和 sum = 22，
 *
 * 5 / \ 4   8 /   / \ 11  13  4 /  \    / \ 7    2  5   1 返回:
 *
 * 3 解释：和为 22 的路径有：[5,4,11,2], [5,8,4,5], [4,11,7] 提示：
 *
 * 节点总数 <= 10000
 *
 *
 * 链接：https://leetcode-cn.com/problems/paths-with-sum-lcci
 *
 * @author chenxu
 * @summary _面试题_04_12_求和路径
 * @since 2021-01-02 23:26
 */
public class _面试题_04_12_求和路径 {

    int res = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);

    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) return 0;
        sum -= root.val;
        //这里不能在sum==0时直接return 1;
        // if(sum==0) return 1;
        return (sum == 0 ? 1 : 0) + dfs(root.left, sum) + dfs(root.right, sum);
    }
}
