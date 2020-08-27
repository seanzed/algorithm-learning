package com.sean.刷题.树;

/**
 * _563_二叉树的坡度
 * 给定一个二叉树，计算整个树的坡度。
 *
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 *
 * 整个树的坡度就是其所有节点的坡度之和。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 *          1
 *        /   \
 *       2     3
 * 输出：1
 * 解释：
 * 结点 2 的坡度: 0
 * 结点 3 的坡度: 0
 * 结点 1 的坡度: |2-3| = 1
 * 树的坡度 : 0 + 0 + 1 = 1
 *
 * 链接：https://leetcode-cn.com/problems/binary-tree-tilt
 *
 * @author chenxu
 * @summary _563_二叉树的坡度
 * @since 2020-08-21 09:32
 */
public class _563_二叉树的坡度 {

    int tilt = 0;   // 结果
    public int findTilt(TreeNode root) {
        helper(root);
        return tilt;
    }

    public int helper(TreeNode root) {
        if (root == null) { // 递归出口，空树的节点之和为0
            return 0;
        }
        int leftTreeSum = helper(root.left);    // 计算当前节点的左子树节点之和
        int rightTreeSum = helper(root.right);  // 计算当前节点的右子树节点之和
        tilt += Math.abs(leftTreeSum - rightTreeSum);   // 计算当前节点的坡度并加入结果
        return root.val + leftTreeSum + rightTreeSum;   // 返回以当前节点为根的整棵树的节点之和
    }

}
