package com.unil.element.impl;

import com.unil.element.Map;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BSTMap() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void add(K key, V value) {
        add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if(node==null) {
            return null;
        }
        return remove(root, key).value;
    }

    private Node remove(Node node, K key) {
        if(node == null) {
            return null;
        }
        if(key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        }
        if(key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
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

    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }
        return minimum(node.left);
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

    @Override
    public void set(K key, V value) {
        Node node = getNode(root, key);
        if(node==null){
            throw new IllegalArgumentException("无相应key存在");
        }
        node.value = value;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node==null?null:node.value;
    }

    private Node getNode(Node node, K key) {
        if(node==null) {
            return null;
        }
        if(key.compareTo(node.key)==0) {
            return node;
        } else if(key.compareTo(node.key)<0) {
            return  getNode(node.left, key);
        } else  {
            return getNode(node.right, key);
        }
    }
    @Override
    public boolean contains(K key) {
        return getNode(root, key)!=null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
}
