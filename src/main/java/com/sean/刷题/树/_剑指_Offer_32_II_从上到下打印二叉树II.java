package com.sean.刷题.树;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * _剑指_Offer_32_II_从上到下打印二叉树II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 *   
 *
 * 例如:
 * 给定二叉树:  [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *   
 *
 * 提示：
 *
 * 节点总数 <= 1000
 *
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
 *
 * @author chenxu
 * @summary _剑指_Offer_32_II_从上到下打印二叉树II
 * @since 2020-08-20 21:13
 */
public class _剑指_Offer_32_II_从上到下打印二叉树II {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode node;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
