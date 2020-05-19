package com.sean.二叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * description 给定一个 N 叉树，返回其节点值的前序遍历。
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 *
 * @author chenxu 2020/05/07 00:26
 */
public class _589_N叉树的前序遍历 {

    public List<Integer> preorder(Node root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) return results;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            results.add(node.val);
            Collections.reverse(node.children);
            for (Node item : node.children) {
                stack.add(item);
            }
        }

        return results;
    }

    List<Integer> res = new ArrayList<>();

    public List<Integer> preorder1(Node root) {
        if (root == null) return res;
        res.add(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            preorder(root.children.get(i));
        }
        return res;
    }
}
