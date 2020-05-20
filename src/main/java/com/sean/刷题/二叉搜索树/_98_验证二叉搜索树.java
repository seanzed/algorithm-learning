package com.sean.刷题.二叉搜索树;

/**
 * description
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 *
 * @author chenxu 2020/05/07 00:40
 */
public class _98_验证二叉搜索树 {

    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }
}
