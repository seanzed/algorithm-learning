package com.sean.刷题.栈;

import com.sean.binarytree.TreeNode;

import java.util.Arrays;
import java.util.Stack;

/**
 * _654_最大二叉树
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 *   
 *
 * 示例 ：
 *
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 *
 * 链接：https://leetcode-cn.com/problems/maximum-binary-tree
 *
 * @author chenxu
 * @summary _654_最大二叉树
 * @since 2020-11-13 17:43
 */
public class _654_最大二叉树 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) return null;
        return findRoot(nums, 0, nums.length);
    }

    /**
     * 找出[l, r)范围的根节点
     */
    private TreeNode findRoot(int[] nums, int l, int r) {
        if (l == r) return null;

        // 找出[l, r)范围内最大值的索引
        int maxIdx = l;
        for (int i = l + 1; i < r; i++) {
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        }

        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = findRoot(nums, l, maxIdx);
        root.right = findRoot(nums, maxIdx + 1, r);
        return root;
    }

    public int[] parentIndexes(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        /*
         * 1.扫描一遍所有的元素
         * 2.保持栈从栈底到栈顶是单调递减的
         */
        int[] lis = new int[nums.length];
        int[] ris = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        // 初始化
        for (int i = 0; i < nums.length; i++) {
            ris[i] = -1;
            lis[i] = -1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                ris[stack.pop()] = i;
            }
            if (!stack.isEmpty()) {
                lis[i] = stack.peek();
            }
            stack.push(i);
        }

        int[] pis = new int[nums.length];
        for (int i = 0; i < pis.length; i++) {
            if (lis[i] == -1 && ris[i] == -1) {
                // i位置的是根节点
                pis[i] = -1;
                continue;
            }

            if (lis[i] == -1) {
                pis[i] = ris[i];
            } else if (ris[i] == -1) {
                pis[i] = lis[i];
            } else if (nums[lis[i]] < nums[ris[i]]) {
                pis[i] = lis[i];
            } else {
                pis[i] = ris[i];
            }
        }
        return pis;
    }

    public static void main(String[] args) {
        _654_最大二叉树 o = new _654_最大二叉树();
        int[] nums = { 3, 2, 1, 6, 0, 5 };
        System.out.println(Arrays.toString(o.parentIndexes(nums)));
    }
}
