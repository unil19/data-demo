package com.unil.element.impl;

import java.util.TreeMap;

public class Trie {
    private static class Node {
        private boolean isWord;
        private TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        size = 0;
        root = new Node();
    }

    public int getSize() {
        return size;
    }

    public void add(String word) {
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
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    public boolean contains(String word) {
        if (word == null) {
            throw new IllegalArgumentException("查找单词不合法");
        }
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            Character character = word.charAt(i);
            if(!cur.next.containsKey(character)){
                return false;
            }
            cur = cur.next.get(character);
        }
        return  cur.isWord;
    }

    public boolean search(String word) {
        if (word == null) {
            throw new IllegalArgumentException("查找单词不合法");
        }
        return matches(root, word, 0);
    }

    private boolean matches(Node node, String word, int index){
        if(index==word.length()){
            return node.isWord;
        }
        Character character = word.charAt(index);
        if('.'!=character && !node.next.containsKey(character)) {
            return false;
        }
        if('.'!=character && node.next.containsKey(character)){
            return matches(node.next.get(character), word, index + 1);
        }
        TreeMap<Character, Node> nextMap = node.next;
        for(char c:nextMap.keySet()){
            if(matches(nextMap.get(c), word, index +1)){
                return true;
            }
        };
        return false;
    }
    public boolean isPrefix(String prefix){
        if (prefix == null) {
            throw new IllegalArgumentException("查找单词不合法");
        }
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            Character character = prefix.charAt(i);
            if(!cur.next.containsKey(character)){
                return false;
            }
            cur = cur.next.get(character);
        }
        return  true;
    }
}
