package com.sean.刷题.二叉搜索树;

/**
 * description 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 *
 * @author chenxu 2020/05/07 00:43
 */
public class _108_将有序数组转换为二叉搜索树 {

    public TreeNode sortedArrayToBST(int[] nums) {

        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (nums == null || nums.length == 0 || left > right) return null;

        int mid = (left + right) % 2 == 1 ? (left + right) / 2 + 1 : (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums,mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode treeNode = new _108_将有序数组转换为二叉搜索树().sortedArrayToBST(nums);
        System.out.println(treeNode);
    }
}
