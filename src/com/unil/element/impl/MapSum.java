package com.unil.element.impl;

import java.util.TreeMap;

public class MapSum {
    private static class Node {
        private int value;
        private TreeMap<Character, Node> next;

        public Node(int value) {
            this.value = value;
            this.next = new TreeMap<>();
        }

        public Node() {
            this(0);
        }
    }
    private Node root;
    public MapSum(){
        root = new Node();
    }

    public void insert(String word, int value){
        if (word == null) {
            throw new IllegalArgumentException("插入单词不合法");
        }
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            Character character = word.charAt(i);
            if (!cur.next.containsKey(character)) {
                cur.next.put(character, new Node());
            }
            cur = cur.next.get(character);
        }
        cur.value += value;
    }

    public int sum(String prefix){
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            Character character = prefix.charAt(i);
            if (!cur.next.containsKey(character)) {
                return 0;
            }
            cur = cur.next.get(character);
        }
        return sumNode(cur);
    }

    private int sumNode(Node node){
        int childSum = 0;
        for(char c: node.next.keySet()){
            childSum += sumNode(node.next.get(c));
        }
        return node.value + childSum;
    }
}
