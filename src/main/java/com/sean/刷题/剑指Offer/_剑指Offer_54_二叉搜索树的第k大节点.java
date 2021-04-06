package com.sean.刷题.剑指Offer;

import com.sean.学习.栈.Stack;

/**
 * _剑指_Offer_54_二叉搜索树的第k大节点
 *
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1 3 / \ 1   4 \    2 输出: 4 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3 5 / \ 3   6 / \ 2   4 / 1 输出: 4  
 *
 * 限制：
 *
 * 1 ≤ k ≤ 二叉搜索树元素个数
 *
 *
 *
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
 *
 * @author chenxu
 * @summary _剑指_Offer_54_二叉搜索树的第k大节点
 * @since 2021-03-22 13:59
 */
public class _剑指Offer_54_二叉搜索树的第k大节点 {

    public int kthLargest(TreeNode root, int k) {
        int count = 1;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.right;
            }

            TreeNode pop = stack.pop();
            if (count == k) {
                return pop.val;
            }

            count++;
            root = pop.left;
        }

        return 0;
    }

    int res, k;

    public int kthLargest2(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        if (k == 0) return;
        if (--k == 0) res = root.val;
        dfs(root.left);
    }
}
