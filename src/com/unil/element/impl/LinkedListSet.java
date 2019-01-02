package com.unil.element.impl;

import com.unil.element.Set;

public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> linkedList;

    public LinkedListSet(){
        this.linkedList = new LinkedList<>();
    }
    @Override
    public void add(E e) {
        if(linkedList.contains(e)){
            return;
        }
        linkedList.addFirst(e);
    }

    @Override
    public void remove(E e) {
        linkedList.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
