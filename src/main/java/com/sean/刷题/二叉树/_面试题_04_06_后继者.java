package com.sean.刷题.二叉树;

/**
 * _面试题_04_06_后继者
 *
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 *
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 *
 * 示例 1:
 *
 * 输入: root = [2,1,3], p = 1
 *
 * 2 / \ 1   3
 *
 * 输出: 2 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 *
 * 5 / \ 3   6 / \ 2   4 / 1
 *
 * 输出: null
 *
 * 链接：https://leetcode-cn.com/problems/successor-lcci
 *
 * @author chenxu
 * @summary _面试题_04_06_后继者
 * @since 2021-01-02 23:44
 */
public class _面试题_04_06_后继者 {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        //问题的本质是找到最靠近p节点且值大于p节点值的那个节点
        TreeNode res = root;
        //设定临时变量方便对树的操作
        TreeNode temp = root;
        while (temp != null) {
            //如果当前节点的值小于等于目标节点的值，那一定不是答案节点，且答案节点在该节点的右孩子中
            if (temp.val <= p.val) {
                temp = temp.right;
            } else {
                //如果当前节点的值大于目标节点的值，那么该节点有可能是答案节点，具体是不是需要遍历其左孩子，寻找更靠近p节点值的答案
                res = temp;
                temp = temp.left;
            }
        }
        return res.val <= p.val ? null : res;
    }
}
