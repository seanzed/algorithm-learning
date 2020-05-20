package com.sean.刷题.二叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * description 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 *
 * @author chenxu 2020/05/07 00:28
 */
public class _559_N叉树的最大深度 {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        } else if (root.children.size() == 0) {
            return 1;
        } else {
            List<Integer> heights = new ArrayList<>();
            for (Node item : root.children) {
                heights.add(maxDepth(item));
            }

            return Collections.max(heights) + 1;
        }
    }

}
