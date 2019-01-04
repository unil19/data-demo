package com.unil.element.impl;

public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array();
    }

    public int size(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    public void add(E e){
        data.addLast(e);
    }

    private void siftUp(int index){
        while (index>0&&data.get(index).compareTo(data.get(parent(index)))>0){
            data.swap(index, parent(index));
            index = parent(index);
        }
    }
    private int parent(int index){
        if(index == 0){
            throw new IllegalArgumentException("错误的堆下标");
        }
        return (index - 1)/2;
    }

    private int leftChild(int index){
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }
}
