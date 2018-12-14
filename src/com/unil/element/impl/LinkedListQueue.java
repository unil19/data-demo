package com.unil.element.impl;

import com.unil.element.Queue;

public class LinkedListQueue<E> implements Queue<E>{

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }
    @Override
    public void enqueue(E e) {
        if(tail == null) {
            head = new Node(e);
            tail = head;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()) {
            throw new IllegalArgumentException("队列为空,不能出队");
        }
        Node delOne = head;
        head = head.next;
        delOne.next = null;
        if(head ==null) {
            tail = null;
        }
        size --;
        return delOne.e;
    }

    @Override
    public E getFront() {
        if(isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node node = head;
        int i = 0;
        while (node != null) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(node.e);
            node = node.next;
            i++;
        }
        sb.append("]");
        return sb.toString();
    }
}
