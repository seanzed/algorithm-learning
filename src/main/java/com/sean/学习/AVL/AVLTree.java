package com.sean.学习.AVL;

import java.util.Comparator;

/**
 * AVLTree
 *
 * @author chenxu
 * @summary AVLTree
 * @since 2020-08-11 20:52
 */
public class AVLTree<E> extends BST<E> {

    public AVLTree() {
        this(null);
    }

    public AVLTree(Comparator<E> comparator) {
        super(comparator);
    }

    @Override
    protected void afterAdd(Node<E> node) {
        while((node = node.parent) != null) {
            if (isBalanced(node)) {
                // 更新的高度

            }
        }
    }

    /**
     * 当前节点是否平衡
     *
     * @param   node
     * @return  {@link boolean}
     * @summary 当前节点是否平衡
     * @author chenxu
     * @version v1
     * @since 2020-08-11 21:11:33
     */
    private boolean isBalanced(Node<E> node) {
        return Math.abs(((AVLNode<E>)node).balanceFactor()) <= 1;
    }

    /**
     * AVL节点
     */
    private static class AVLNode<E> extends Node<E> {

        int height = 1;

        /**
         * 构造函数
         *
         * @param   element 元素
         * @param   parent 父节点
         * @summary 父节点
         * @author chenxu
         * @version v1
         * @since 2020-08-11 21:06:49
         */
        public AVLNode(E element, Node<E> parent) {
            super(element, parent);
        }

        /**
         * 平衡因子
         *
         * @return  {@link int}
         * @summary 平衡因子
         * @author chenxu
         * @version v1
         * @since 2020-08-11 21:06:26
         */
        public int balanceFactor() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;
            return leftHeight - rightHeight;
        }

        /**
         * 更新节点高度
         *
         * @summary 更新节点高度
         * @author chenxu
         * @version v1
         * @since 2020-08-11 21:05:58
         */
        public void updateHeight() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;
            height = 1 + Math.max(leftHeight, rightHeight);
        }

        /**
         * 比较子节点，返回较高的子节点
         *
         * @return  {@link Node<E>}
         * @summary 比较子节点，返回较高的子节点
         * @author chenxu
         * @version v1
         * @since 2020-08-11 21:05:16
         */
        public Node<E> tallerChild() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;
            if (leftHeight > rightHeight) return left;
            if (leftHeight < rightHeight) return right;
            return isLeftChild() ? left : right;
        }

        @Override
        public String toString() {
            String parentString = "null";
            if (parent != null) {
                parentString = parent.element.toString();
            }
            return element + "_p(" + parentString + ")_h(" + height + ")";
        }

    }
}
