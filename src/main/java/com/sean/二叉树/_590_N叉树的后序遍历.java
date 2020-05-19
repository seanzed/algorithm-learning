package com.sean.二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * description 给定一个 N 叉树，返回其节点值的后序遍历。
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 *
 * @author chenxu 2020/05/07 00:27
 */
public class _590_N叉树的后序遍历 {

    public List<Integer> results = new ArrayList<>();

    public List<Integer> postorder(Node root) {

        if (root == null) return results;
        for (int i = 0; i < root.children.size(); i++) {
            postorder(root.children.get(i));
        }
        results.add(root.val);
        return results;
    }
}
