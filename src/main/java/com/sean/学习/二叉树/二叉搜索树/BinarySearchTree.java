package com.sean.学习.二叉树.二叉搜索树;

import com.sean.学习.printer.BinaryTreeInfo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * description 二叉搜索树
 *
 * @author xchen11 2020/05/20 10:25
 */
@SuppressWarnings("unchecked")
public class BinarySearchTree<E> implements BinaryTreeInfo {

    private int size;

    private Node<E> root;

    private Comparator<E> comparator;

    /**
     * 无参构造器
     */
    public BinarySearchTree() {
        this(null);
    }

    /**
     * 有参构造器
     * @param comparator 比较接口
     */
    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    /**
     * 二叉树的个数
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 二叉树元素是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 清空二叉搜索树
     */
    public void clear() {
        root = null;
        size = 0;
    }

    public void add(E element) {
        elementNotNullCheck(element);

        // 添加第一个节点
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }

        // 添加的不是第一个节点
        // 找到父节点
        Node<E> parent = root;
        Node<E> node = root;
        int cmp = 0;
        while (node != null) {
            cmp = compare(element, node.element);
            parent = node;
            // 如果大于0，说明当前element比node的element大
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else {
                node.element = element;
                return;
            }
        }

        Node<E> newNode = new Node<>(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;
    }

    /**
     * 根据元素值从二叉树中删除元素
     * @param element
     */
    public void remove(E element) {
        remove(node(element));
    }

    private void remove(Node<E> node) {
        if (root == null) return;

        size--;

        // 当前节点度为2
        if (node.hasTwoChildren()) {
            // 找到后继节点
            Node<E> succ = successor(node);
            // 用后继节点的值覆盖度为2的节点的值
            node.element = succ.element;
            // 删除后继节点
            node = succ;
        }

        // 删除node节点(node的度必然是0或者1)
        Node<E> replacement = node.left != null ? node.left : node.right;

        if (replacement != null) {// node的度为1的节点
            // 更改parent
            replacement.parent = node.parent;
            // 更改parent的left, right的指向
            if (node.parent == null) { // node是度为1的节点并且是根节点
                root = replacement;
            } else if (node == node.parent.left) {// node 当前节点是父节点左子树
                // 将replacement赋值到当前节点
                node.parent.left = replacement;
            } else {
                // 将replacement赋值到当前节点
                node.parent.right = replacement;
            }
        } else if (node.parent == null) {
            root = null;
        } else { // node是叶子节点，但不是根节点
            if (node == node.parent.left) {
                node.parent.left = null;
            } else { // node == node.parent.right
                node.parent.right = null;
            }
        }

    }

    public boolean contains(E element) {
        return node(element) != null;
    }



    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>)node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>)node).right;
    }

    @Override
    public Object string(Object node) {
        Node<E> myNode = (Node<E>)node;
        String parentString = "null";
        if (myNode.parent != null) {
            parentString = myNode.parent.element.toString();
        }
        return myNode.element + "_p(" + parentString + ")";
    }

    /**
     * 根据元素查找二叉树中对应的节点
     * @param element 元素值
     * @return
     */
    private Node<E> node(E element) {
        Node<E> node = root;

        while(node != null) {
            int cmp =compare(element, node.element);
            if (cmp == 0) return node;
            if (cmp > 0) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        return null;
    }

    /**
     * 检查元素是否为空，如果为空抛出异常
     *
     * @param element
     */
    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    /**
     * 二叉树前序遍历
     * @param visitor
     */
    public void preorder(Visitor<E> visitor) {
        if (visitor == null) return;
        preorder(root, visitor);
    }

    /**
     * 二叉树前序遍历
     * @param node
     * @param visitor
     */
    private void preorder(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) return;

        visitor.stop = visitor.visit(node.element);
        preorder(node.left, visitor);
        preorder(node.right, visitor);

    }

    /**
     * 二叉树中序遍历
     * @param visitor
     */
    public void inorder(Visitor<E> visitor) {
        if (visitor == null) return;
        inorder(root, visitor);
    }

    /**
     * 二叉树中序遍历
     * @param node
     * @param visitor
     */
    private void inorder(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) return;

        inorder(node.left, visitor);
        if (visitor.stop) return;
        visitor.stop = visitor.visit(node.element);
        inorder(node.right, visitor);
    }

    /**
     * 二叉树后序遍历
     * @param visitor
     */
    public void postorder(Visitor<E> visitor) {
        if (visitor == null) return;
        postorder(root, visitor);
    }

    /**
     * 二叉树后序遍历
     * @param node
     * @param visitor
     */
    private void postorder(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) return;

        postorder(node.left, visitor);
        postorder(node.right, visitor);
        if (visitor.stop) return;
        visitor.stop = visitor.visit(node.element);
    }

    public boolean isComplete() {
        if (root == null) return false;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        boolean leaf = false;
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            if (leaf && !node.isLeaf()) return false;

            if (node.left != null) {
                queue.offer(node.left);
            } else if (node.right != null) { // node.left == null && node.right != null
                return false;
            }

            if (node.right != null) {
                queue.offer(node.right);
            } else { // node.right == null
                leaf = true;
            }
        }

        return true;
    }

//	public boolean isComplete() {
//		if (root == null) return false;
//
//		Queue<Node<E>> queue = new LinkedList<>();
//		queue.offer(root);
//
//		boolean leaf = false;
//		while (!queue.isEmpty()) {
//			Node<E> node = queue.poll();
//			if (leaf && !node.isLeaf()) return false;
//
//			if (node.left != null && node.right != null) {
//				queue.offer(node.left);
//				queue.offer(node.right);
//			} else if (node.left == null && node.right != null) {
//				return false;
//			} else { // 后面遍历的节点都必须是叶子节点
//				leaf = true;
//				if (node.left != null) {
//					queue.offer(node.left);
//				}
//			}
//		}
//
//		return true;
//	}

    /**
     * 二叉树层次遍历
     * @param visitor
     */
    public void levelOrder(Visitor<E> visitor) {
        if (root == null || visitor == null) return;

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            Node<E> node = queue.poll();
            if (visitor.visit(node.element)) return;

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    /**
     * 树的高度
     * @return
     */
    public int height() {
        if (root == null) return 0;

        // 树的高度
        int height = 0;
        // 存储每层元素
        int levelSize = 1;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            levelSize--;

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }

            // 如果levelSize值为0时，说明该树的这一层遍历完成
            if (levelSize == 0) {
                levelSize = queue.size();
                height++;
            }
        }
        return height;
    }

    /**
     * 树的高度
     * @return
     */
    public int height2() {
        return height2(root);
    }

    /**
     * 树的高度
     * @param node
     */
    private int height2(Node<E> node) {
        if (root == null) return 0;
        return Math.max(height2(node.left), height2(node.right))  + 1;
    }

    /**
     * 根据当前节点查询前驱节点
     * @param node
     * @return
     */
    private Node<E> predecessor(Node<E> node) {
        if (root == null) return null;

        // 前驱节点在左子树当中（left.right.right.right....）
        Node<E> p = node.left;
        if (p != null) {
            while (p.right != null) {
                p = p.right;
            }
            return p;
        }

        // 从父节点、祖父节点中寻找前驱节点
        while (node.parent != null && node == node.parent.left) {
            node = node.parent;
        }

        // node.parent == null
        // node == node.parent.right
        return node.parent;
    }

    /**
     * 根据当前节点查询后继节点
     * @param node
     * @return
     */
    private Node<E> successor(Node<E> node) {
        if (root == null) return null;

        // 后继节点在右字数当中(right.left.left.left....)
        Node<E> succ = node.right;
        if (succ != null) {
            while (succ.left != null) {
                succ = succ.left;
            }
            return succ;
        }

        // 从父节点、祖父节点中寻找后继节点
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }

        // node.parent == null
        // node == node.parent.left
        return node.parent;
    }

    /**
     * 比较方法
     * @param e1
     * @param e2
     * @return
     */
    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>)e1).compareTo(e2);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(root, sb, "");
        return sb.toString();
    }

    private void toString(Node<E> node, StringBuilder sb, String prefix) {
        if (node == null) return;

        toString(node.left, sb, prefix + "L---");
        sb.append(prefix).append(node.element).append("\n");
        toString(node.right, sb, prefix + "R---");
    }

    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public boolean hasTwoChildren() {
            return left != null && right != null;
        }
    }

    public static abstract class Visitor<E> {

        boolean stop;
        /**
         * @return 如果返回true，就代表停止遍历
         */
        public abstract boolean visit(E element);
    }
}
