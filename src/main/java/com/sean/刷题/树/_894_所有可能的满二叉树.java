package com.sean.刷题.树;

import java.util.ArrayList;
import java.util.List;

/**
 * _894_所有可能的满二叉树 满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
 *
 * 返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
 *
 * 答案中每个树的每个结点都必须有 node.val=0。
 *
 * 你可以按任何顺序返回树的最终列表。
 *
 *   
 *
 * 示例：
 *
 * 输入：7 输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 *
 * 链接：https://leetcode-cn.com/problems/all-possible-full-binary-trees
 *
 * @author chenxu
 * @summary _894_所有可能的满二叉树
 * @since 2020-08-22 17:31
 */
public class _894_所有可能的满二叉树 {

    public List<TreeNode> allPossibleFBT(int N) {
        //N为偶数不可能满二叉树
        if ((N & 1) == 0) {
            return new ArrayList<>(0);
        }
        List<TreeNode> list = new ArrayList<>();
        if (N == 1) {
            //N为1返回当前节点
            list.add(new TreeNode(0));
            return list;
        }
        //N的值应减一，因为去掉了根节点
        --N;
        //i为N重分给左节点的节点数，每次加2因为每次向下分配都要多两个节点
        for (int i = 1; i < N; i += 2) {
            //这里list存着分配i个节点后的左节点的所有情况list
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i);
            for (TreeNode nodeL : left) {
                //双重循环，分别把左右节点的各种情况赋予根节点的左右节点，并存储
                for (TreeNode nodeR : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = nodeL;
                    root.right = nodeR;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
