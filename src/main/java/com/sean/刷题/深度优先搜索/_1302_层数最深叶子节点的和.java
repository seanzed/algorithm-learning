package com.sean.刷题.深度优先搜索;

import java.util.LinkedList;

/**
 * _1302_层数最深叶子节点的和
 * 给你一棵二叉树，请你返回层数最深的叶子节点的和。
 *
 *   
 *
 * 示例：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 *   
 *
 * 提示：
 *
 * 树中节点数目在  1  到  10^4  之间。
 * 每个节点的值在  1  到  100 之间。
 *
 * 链接：https://leetcode-cn.com/problems/deepest-leaves-sum
 *
 * @author chenxu
 * @summary _1302_层数最深叶子节点的和
 * @since 2020-08-20 16:44
 */
public class _1302_层数最深叶子节点的和 {

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;

        int res = 0;
        LinkedList<TreeNode> nodeStack = new LinkedList<>();
        nodeStack.add(root);

        while (!nodeStack.isEmpty()) {
            int size = nodeStack.size();
            int currSum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = nodeStack.poll();
                currSum += node.val;
                if (node.left != null) {
                    nodeStack.add(node.left);
                }

                if (node.right != null) {
                    nodeStack.add(node.right);
                }
                res = currSum;
            }
        }

        return res;
    }
}
