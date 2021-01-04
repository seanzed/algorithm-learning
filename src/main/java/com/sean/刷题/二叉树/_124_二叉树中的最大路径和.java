package com.sean.刷题.二叉树;

/**
 * description
 *
 * @author chenxu 2020/06/08 15:55
 */
public class _124_二叉树中的最大路径和 {

    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = Math.max(dfs(root.left), 0);
        int rightMax = Math.max(dfs(root.right), 0);
        res = Math.max(res, root.val + leftMax + rightMax);

        return root.val + Math.max(leftMax, rightMax);
    }

}
