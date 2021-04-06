package com.sean.刷题.面试题;

import com.sean.刷题.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * _面试题_04_09_二叉搜索树序列
 *
 * 从左向右遍历一个数组，通过不断将其中的元素插入树中可以逐步地生成一棵二叉搜索树。给定一个由不同节点组成的二叉搜索树，输出所有可能生成此树的数组。
 *
 *  
 *
 * 示例： 给定如下二叉树
 *
 * 2 / \ 1   3 返回：
 *
 * [ [2,1,3], [2,3,1] ]
 *
 *
 * 链接：https://leetcode-cn.com/problems/bst-sequences-lcci
 *
 * @author chenxu
 * @summary _面试题_04_09_二叉搜索树序列
 * @since 2021-03-22 10:57
 */
public class _面试题_04_09_二叉搜索树序列 {

    // 这两个声明成全局变量，这也回溯函数就少传点参数
    private LinkedList<Integer> path = new LinkedList<>();
    private List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> BSTSequences(TreeNode root) {
        Deque<TreeNode> dq = new LinkedList<>();
        if (root != null) {
            dq.offer(root);
        }
        dfs(dq);
        return result;
    }

    // 1.确定递归函数返回值和参数
    public void dfs(Deque<TreeNode> dq) {
        // 2.确定递归终止条件
        // dq是该层剩下可选节点的候选队列，若队列为空，则说明没有候选元素了
        // 因此可直接把当前路径添加到结果集，然后返回
        if (dq.isEmpty()) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        //3.确定回溯函数的遍历过程

        // 当前层可与选择的候选节点的个数
        int size = dq.size();
        while (size > 0) {
            TreeNode cur = dq.pollFirst();
            // 向路径中添加当前值
            path.add(cur.val);
            // 记录添加的子节点数量，等会回溯时需要用
            int children = 0;
            // 向候选队列中添加子节点
            if (cur.left != null) {
                children++;
                dq.offerLast(cur.left);
            }
            if (cur.right != null) {
                children++;
                dq.offerLast(cur.right);
            }

            // 递归
            dfs(dq);

            // 回溯候选队列
            while (children > 0) {
                dq.pollLast();
                children--;
            }
            dq.offerLast(cur);

            // 回溯路径
            path.removeLast();
            // 当前节点处理完毕，数量减一
            size--;
        }
    }
}
