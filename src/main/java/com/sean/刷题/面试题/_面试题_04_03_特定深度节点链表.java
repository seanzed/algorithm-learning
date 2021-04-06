package com.sean.刷题.面试题;

import com.sean.刷题.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * _面试题_04_03_特定深度节点链表
 *
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 *
 *  
 *
 * 示例：
 *
 * 输入：[1,2,3,4,5,null,7,8]
 *
 *         1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 *    /
 *   8
 *
 * 输出：[[1],[2,3],[4,5,7],[8]]
 *
 * 链接：https://leetcode-cn.com/problems/list-of-depth-lcci
 *
 * @author chenxu
 * @summary _面试题_04_03_特定深度节点链表
 * @since 2021-03-22 11:44
 */
public class _面试题_04_03_特定深度节点链表 {

    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) return new ListNode[0];
        List<List<Integer>> resList = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);

        TreeNode node;
        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                list.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            resList.add(list);
        }

        ListNode[] listNodes = new ListNode[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            List<Integer> list = resList.get(i);
            ListNode listNode = new ListNode(list.get(0));
            ListNode curNode = listNode;
            for (int j = 1; j < list.size(); j++) {
                curNode.next = new ListNode(list.get(j));
                curNode = curNode.next;
            }
            listNodes[i] = listNode;
        }
        return listNodes;
    }
}
