package com.unil.element.impl;

import java.util.TreeMap;

public class Trie {
    private static class Node{
        private boolean isWord;
        private TreeMap<Character,Node> next;
        public Node(boolean isWord){
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }
        public Node(){
            this(false);
        }
    }
    private Node root;
    private int size;
    public Trie(){
        size = 0;
        root = new Node();
    }
    public int getSize(){
        return size;
    }
    public void add(String word){
        if(word==null){
            throw new IllegalArgumentException("插入单词不合法");
        }
        Node cur = root;
        for(int i=0; i<word.length();i++){
            Character character = word.charAt(i);
            if(!cur.next.containsKey(character)){
                cur.next.put(character, new Node());
            }
            cur = cur.next.get(character);
        }
        if(!cur.isWord){
            cur.isWord = true;
            size++;
        }
    }
}
