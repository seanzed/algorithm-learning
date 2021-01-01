package com.sean.刷题.树;

/**
 * _剑指_Offer_27_二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *         4
 *      /    \
 *    2       7
 *   / \    / \
 * 1    3 6    9
 * 镜像输出：
 *
 *         4
 *      /    \
 *    7       2
 *   / \    / \
 * 9    6 3     1
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 1000
 *
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
 *
 * @author chenxu
 * @summary _剑指_Offer_27_二叉树的镜像
 * @since 2020-08-20 20:50
 */
public class _剑指_Offer_27_二叉树的镜像 {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return root;
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);

        return root;
    }
}
