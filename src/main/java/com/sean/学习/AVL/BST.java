package com.sean.学习.AVL;

import java.util.Comparator;

/**
 * BST
 *
 * @author chenxu
 * @summary BST
 * @since 2020-08-11 20:03
 */
public class BST<E> extends BinaryTree<E> {

    private Comparator<E> comparator;

    public BST() {
        this(null);
    }

    public BST(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    /**
     * 添加节点
     *
     * @param   element
     * @summary 添加节点
     * @author chenxu
     * @version v1
     * @since 2020-08-11 20:06:02
     */
    public void add(E element) {
        elementNotNullCheck(element);

        // 添加第一个节点
        if (root == null) {
            root = createNode(element, null);
            size++;

            // 新添加节点之后的处理
            afterAdd(root);
            return;
        }

        // 添加的不是第一个节点
        // 找到父节点
        Node<E> parent = root;
        Node<E> node = root;
        int cmp = 0;
        do {
            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else {
                // 相等
                node.element= element;
                return;
            }
        } while (node != null);

        // 看看插入到父节点的哪个位置
        Node<E> newNode = createNode(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }

        size++;

        // 新添加节点之后的处理
        afterAdd(node);
    }

    /**
     * 插入节点后的处理
     *
     * @param   node
     * @summary 插入节点后的处理
     * @author chenxu
     * @version v1
     * @since 2020-08-11 20:09:55
     */
    protected void afterAdd(Node<E> node) {

    }

    /**
     * 删除node之后的调整
     *
     * @param   node
     * @summary 删除node之后的调整
     * @author chenxu
     * @version v1
     * @since 2020-08-11 20:10:43
     */
    protected void afterRemove(Node<E> node) {

    }

    /**
     * 删除元素
     *
     * @param   element
     * @summary 删除元素
     * @author chenxu
     * @version v1
     * @since 2020-08-11 20:29:12
     */
    public void remove(E element) {
        remove(node(element));
    }

    /**
     * 查看是否包含该元素
     *
     * @param   element
     * @return  {@link boolean}
     * @summary 查看是否包含该元素
     * @author chenxu
     * @version v1
     * @since 2020-08-11 20:29:28
     */
    public boolean contains(E element) {
        return node(element) != null;
    }

    /**
     * 删除节点
     *
     * @param   node
     * @summary 删除节点
     * @author chenxu
     * @version v1
     * @since 2020-08-11 20:29:53
     */
    private void remove(Node<E> node) {
        if (node == null) return;

        size--;

        // 度为2的节点
        if (node.hasTwoChildren()) {
            // 找到后继节点
            Node<E> s = successor(node);
            // 用后继节点的值覆盖度为2的节点的值
            node.element = s.element;
            // 删除后继节点
            node = s;
        }

        // 删除node节点(node的度必然是是1或者0)
        Node<E> replacement = node.left != null ? node.left : node.right;

        if (replacement != null) {
            // node是度为1的节点
            // 更改parent
            replacement.parent = node.parent;
            // 更改parent的left、right的指向
            if (node.parent == null) {
                // node是度为1的节点并且是根节点
                root = replacement;
            } else if (node == node.parent.left) {
                node.parent.left = replacement;
            } else {
                node.parent.right = replacement;
            }

            // 删除节点之后的处理
            afterRemove(node);
        } else if (node.parent == null) { // node是叶子节点并且是根节点
            root = null;

            // 删除节点之后的处理
            afterRemove(node);
        } else { // node是叶子节点，但不是根节点
            if (node == node.parent.left) {
                node.parent.left = null;
            } else { // node == node.parent.right
                node.parent.right = null;
            }

            // 删除节点之后的处理
            afterRemove(node);
        }
    }

    private Node<E> node(E element) {
        Node<E> node = root;
        while (node != null) {
            int cmp = compare(element, node.element);
            if (cmp == 0) return node;
            if (cmp > 0) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return node;
    }

    /**
     * 比较e1和e2, 返回值等于0, 代表e1和e2相等; 返回值大于0, 代表e1大于e2； 返回值小于0，代表e1小于e2
     *
     * @param   e1
     * @param   e2
     * @return  {@link int}
     * @summary 比较e1和e2, 返回值等于0, 代表e1和e2相等; 返回值大于0, 代表e1大于e2； 返回值小于0，代表e1小于e2
     * @author chenxu
     * @version v1
     * @since 2020-08-11 20:15:05
     */
    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>)e1).compareTo(e2);
    }

    /**
     * 检查节点是否为空
     *
     * @param   element
     * @summary 检查节点是否为空
     * @author chenxu
     * @version v1
     * @since 2020-08-11 20:07:40
     */
    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }
}
