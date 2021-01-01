package com.sean.刷题.深度优先搜索;

import java.util.ArrayList;
import java.util.List;

/**
 * _872_叶子相似的树
 * 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个  叶值序列 。
 *
 *
 *
 * 举个例子，如上图所示，给定一颗叶值序列为  (6, 7, 4, 9, 8)  的树。
 *
 * 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是  叶相似  的。
 *
 * 如果给定的两个头结点分别为  root1 和  root2  的树是叶相似的，则返回  true；否则返回 false 。
 *
 *   
 *
 * 提示：
 *
 * 给定的两颗树可能会有  1  到 200  个结点。
 * 给定的两颗树上的值介于 0 到 200 之间。
 *
 * 链接：https://leetcode-cn.com/problems/leaf-similar-trees
 *
 * @author chenxu
 * @summary _872_叶子相似的树
 * @since 2020-08-20 09:32
 */
public class _872_叶子相似的树 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        preorder(root1, list1);
        preorder(root2, list2);

        return list1.equals(list2);
    }

    public void preorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
        preorder(root.left, list);
        preorder(root.right, list);
    }
}
