package com.sean.刷题.树;

/**
 * _543_二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 *  
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 *  
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
 *
 * @author chenxu
 * @summary _543_二叉树的直径
 * @since 2020-08-22 15:01
 */
public class _543_二叉树的直径 {

    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);

        ans = Math.max(ans, left + right + 1);

        return Math.max(left, right) + 1;
    }
}
