package com.sean.刷题.树;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * _1008_先序遍历构造二叉树 返回与给定先序遍历  preorder 相匹配的二叉搜索树（binary search tree）的根结点。
 *
 * (回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，对于  node.left  的任何后代，值总 < node.val，而 node.right 的任何后代，值总 >
 * node.val。此外，先序遍历首先显示节点的值，然后遍历 node.left，接着遍历 node.right。）
 *
 *   
 *
 * 示例：
 *
 * 输入：[8,5,1,7,10,12] 输出：[8,5,10,1,7,null,12]
 *
 *   
 *
 * 提示：
 *
 * 1 <= preorder.length <= 100 先序  preorder  中的值是不同的。
 *
 * 链接：https://leetcode-cn.com/problems/construct-binary-search-tree-from-preorder-traversal
 *
 * @author chenxu
 * @summary _1008_先序遍历构造二叉树
 * @since 2020-08-31 13:09
 */
public class _1008_先序遍历构造二叉树 {

    private int idx = 0;

    private int[] preorder;

    private int n;

    public TreeNode bstFromPreorder(int[] preorder) {
        this.preorder = preorder;
        this.n = preorder.length;
        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode helper(int lower, int upper) {
        if (idx == n) return null;

        int val = preorder[idx];
        if (val < lower || val > upper) return null;

        idx++;
        TreeNode root = new TreeNode(val);
        root.left = helper(lower, val);
        root.right = helper(val, upper);
        return root;
    }

    public TreeNode bstFromPreorder1(int[] preorder) {
        int n = preorder.length;
        if (n == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> deque = new ArrayDeque<TreeNode>();
        deque.push(root);

        for (int i = 1; i < n; i++) {
            // take the last element of the deque as a parent
            // and create a child from the next preorder element
            TreeNode node = deque.peek();
            TreeNode child = new TreeNode(preorder[i]);
            // adjust the parent
            while (!deque.isEmpty() && deque.peek().val < child.val) {
                node = deque.pop();
            }
            // follow BST logic to create a parent-child link
            if (node.val < child.val) {
                node.right = child;
            } else {
                node.left = child;
            }
            // add the child into deque
            deque.push(child);
        }
        return root;
    }
}
