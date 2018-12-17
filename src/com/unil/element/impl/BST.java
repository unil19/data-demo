package com.unil.element.impl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    public void inOrder() {
        inOrder(root);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print("\n" + node.e);
        inOrder(node.right);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print("\n" + node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrderNature() {
        Stack<Node> operatingNodeStack = new Stack<>();
        operatingNodeStack.push(root);
        while (!operatingNodeStack.empty()) {
            Node curNode = operatingNodeStack.pop();
            System.out.print(curNode.e + "\n");
            if (curNode.right != null) {
                operatingNodeStack.push(curNode.right);
            }
            if (curNode.left != null) {
                operatingNodeStack.push(curNode.left);
            }
        }
    }

    public void levelOrder() {
        Queue<Node> operatingQueue = new LinkedList<>();
        operatingQueue.add(root);
        while (!operatingQueue.isEmpty()) {
            Node curNode = operatingQueue.remove();
            System.out.print(curNode.e + "\n");
            if (curNode.left != null) {
                operatingQueue.add(curNode.left);
            }
            if (curNode.right != null) {
                operatingQueue.add(curNode.right);
            }
        }
    }

    public E minimum() {
        if (isEmpty()) {
            throw new IllegalArgumentException("空树");
        }
        return minimum(root).e;
    }

    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    public E maximum() {
        if (isEmpty()) {
            throw new IllegalArgumentException("空树");
        }
        return maximum(root).e;
    }

    private Node maximum(Node node){
        if(node.right == null){
            return node;
        }
        return maximum(node.right);
    }

    public E removeMin() {
        E minElement = minimum();
        root = removeMin(root);
        return minElement;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node restNode = node.right;
            node.right = null;
            size--;
            return restNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        E maxElement = maximum();
        root = removeMax(root);
        return maxElement;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node restNode = node.left;
            node.left = null;
            size--;
            return restNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if(node == null) {
            return null;
        }
        if(e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        }
        if(e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        }
        if(node.left==null){
            Node restNode = node.right;
            node.right = null;
            size--;
            return restNode;
        }
        if(node.right == null) {
            Node restNode = node.left;
            node.left = null;
            size--;
            return restNode;
        }
        Node minInRight = minimum(node.right);
        minInRight.right = removeMin(node.right);
        minInRight.left = node.left;
        node.left = node.right = null;
        return minInRight;
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print("\n" + node.e);
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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        generateBstString(root, 0, result);
        return result.toString();
    }

    private void generateBstString(Node node, int depth, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append("当前节点为" + node.e + ",节点深度" + depth + "\n");
        depth++;
        generateBstString(node.left, depth, sb);
        generateBstString(node.right, depth, sb);
    }
}
