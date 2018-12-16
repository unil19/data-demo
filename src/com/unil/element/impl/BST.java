package com.unil.element.impl;

public class BST<E extends Comparable> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //添加到叶节点
    public void add(E e) {
        root = add(root, e);
    }

    //看二分搜索树种是否包含元素e
    public boolean contains(E e) {
        return contains(root, e);
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print("\n" + node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.equals(node.e)) {
            return true;
        }
        if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }
}
