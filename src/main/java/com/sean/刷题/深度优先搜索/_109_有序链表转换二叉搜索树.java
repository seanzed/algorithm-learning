package com.sean.刷题.深度优先搜索;

/**
 * _109_有序链表转换二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点  的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 *
 * @author chenxu
 * @summary _109_有序链表转换二叉搜索树
 * @since 2020-08-20 20:13
 */
public class _109_有序链表转换二叉搜索树 {

    ListNode globalHead;

    /**
     * 分治算法 + 深度优先遍历
     *
     * @param   head
     * @return  {@link TreeNode}
     * @summary
     * @author chenxu
     * @version v1
     * @since 2020-08-20 20:28:12
     */
    public TreeNode sortedListToBST(ListNode head) {
        globalHead = head;
        int length = getLength(head);
        return buildTree(0, length - 1);
    }

    public int getLength(ListNode head) {
        int ret = 0;
        while (head != null) {
            ret++;
            head = head.next;
        }
        return ret;
    }

    public TreeNode buildTree(int left, int right) {
        if (left > right) return null;

        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode();
        root.left = buildTree(left, mid - 1);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        root.right = buildTree(mid + 1, right);
        return root;
    }

    /**
     * 分治解法
     *
     * @param   head
     * @summary 分治解法
     * @author chenxu
     * @version v1
     * @since 2020-08-20 20:21:21
     */
    public TreeNode sortedListToBST2(ListNode head) {
        return buildTree2(head, null);
    }

    public TreeNode buildTree2(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }

        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree2(left, mid);
        root.right = buildTree2(mid.next, right);
        return root;
    }

    public ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;

        while (fast != right && fast.next != right) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
