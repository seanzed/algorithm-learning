package com.sean.刷题.剑指Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * _剑指Offer_32_III_从上到下打印二叉树III
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
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
 *   [20,9],
 *   [15,7]
 * ]
 *   
 *
 * 提示：
 *
 * 节点总数 <= 1000
 *
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
 *
 * @author chenxu
 * @summary _剑指Offer_32_III_从上到下打印二叉树III
 * @since 2020-09-10 23:33
 */
public class _剑指Offer_32_III_从上到下打印二叉树III {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<List<Integer>> res = new ArrayList<>();
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(level % 2 == 1) {
                    // 偶数层 -> 队列尾部
                    tmp.addLast(node.val);
                }
                else {
                    // 奇数层 -> 队列头部
                    tmp.addFirst(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            level++;
            res.add(tmp);
        }
        return res;
    }
}
