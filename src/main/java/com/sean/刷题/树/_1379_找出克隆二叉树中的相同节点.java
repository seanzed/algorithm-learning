package com.sean.刷题.树;

/**
 * _1379_找出克隆二叉树中的相同节点
 * 给你两棵二叉树，原始树 original 和克隆树 cloned，以及一个位于原始树 original  中的目标节点  target。
 *
 * 其中，克隆树 cloned  是原始树 original  的一个 副本 。
 *
 * 请找出在树  cloned  中，与  target  相同  的节点，并返回对该节点的引用（在 C/C++ 等有指针的语言中返回 节点指针，其他语言返回节点本身）。
 *
 *
 *
 * 注意：
 *
 * 你 不能 对两棵二叉树，以及 target  节点进行更改。
 * 只能 返回对克隆树  cloned  中已有的节点的引用。
 * 进阶：如果树中允许出现值相同的节点，你将如何解答？
 *
 * 链接：https://leetcode-cn.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree
 *
 * @author chenxu
 * @summary _1379_找出克隆二叉树中的相同节点
 * @since 2020-08-22 16:52
 */
public class _1379_找出克隆二叉树中的相同节点 {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) return null;

        if (original == target) return cloned;

        // 递归左子树
        TreeNode res = getTargetCopy(original.left,cloned.left,target);
        if (res != null){
            return res;
        }
        // 递归右子树
        res = getTargetCopy(original.right,cloned.right,target);
        if (res != null){
            return res;
        }
        return null;
    }
}
