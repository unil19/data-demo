package com.unil.element.impl;

import com.unil.element.Stack;

public class LinkedListStack<E> implements Stack<E>{

    private LinkedList<E> list;


    public LinkedListStack(){
        list = new LinkedList<>();
    }

    @Override
    public void push(E element) {
        list.addFirst(element);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public String toString() {
        return "LinkedListStack{" +
                "list=" + list +
                '}';
    }
}
