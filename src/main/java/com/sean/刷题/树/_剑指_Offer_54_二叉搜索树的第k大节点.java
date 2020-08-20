package com.sean.刷题.树;

import com.sean.学习.数组.List;
import com.sean.学习.数组.动态数组.ArrayList;

import java.util.Objects;
import java.util.Stack;

/**
 * _剑指_Offer_54_二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 *  
 *
 * 限制：
 *
 * 1 ≤ k ≤ 二叉搜索树元素个数
 *
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
 *
 * @author chenxu
 * @summary _剑指_Offer_54_二叉搜索树的第k大节点
 * @since 2020-08-20 20:56
 */
public class _剑指_Offer_54_二叉搜索树的第k大节点 {

    public int kthLargest(TreeNode root, int k) {
        int count = 1;
        Stack<TreeNode> stack = new Stack<>();
        while (Objects.nonNull(root) || !stack.empty()) {
            while (Objects.nonNull(root)) {
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

    List<Integer> res = new ArrayList<>();

    public int kthLargest1(TreeNode root, int k) {
        inorder1(root);
        return res.get(res.size() - k);
    }

    public void inorder1(TreeNode root) {
        if (root == null) return;

        inorder1(root.left);
        res.add(root.val);
        inorder1(root.right);
    }
}
