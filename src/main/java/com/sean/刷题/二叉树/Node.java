package com.sean.刷题.二叉树;

import java.util.List;

/**
 * description
 *
 * @author chenxu 2020/05/07 00:26
 */
public class Node {

    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
