package com.sean.刷题.剑指Offer;

import java.util.HashMap;
import java.util.Map;

/**
 * _剑指Offer_07_重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *
 *
 * 例如，给出
 *
 * 前序遍历 preorder =  [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 *
 *
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 *
 * @author chenxu
 * @summary _剑指Offer_07_重建二叉树
 * @since 2020-12-17 22:00
 */
public class _剑指Offer_07_重建二叉树 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hash.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length, hash);
        return root;
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preLeftIdx, int preRightIdx, int inLeftIdx, int inRightIdx, Map<Integer, Integer> map) {
        if (preLeftIdx > preRightIdx || inLeftIdx > inRightIdx) {
            return null;
        }
        int rootVal = preorder[preLeftIdx];
        Integer rootIndex = map.get(rootVal);
        int tmpLength = rootIndex - inLeftIdx;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preorder, inorder, preLeftIdx + 1, preLeftIdx + tmpLength, inLeftIdx, rootIndex - 1, map);
        root.right = buildTree(preorder, inorder, preLeftIdx + tmpLength + 1, preRightIdx, rootIndex + 1, inRightIdx, map);
        return root;
    }
}
