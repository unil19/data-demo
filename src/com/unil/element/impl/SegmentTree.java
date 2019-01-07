package com.unil.element.impl;

public class SegmentTree<E>{
    private E[] tree;
    private E[] data;
    public SegmentTree(E[] arr){
        data = (E[]) new Object[arr.length];
        for(int i=0;i<arr.length;i++){
            data[i] = arr[i];
        }
        tree = (E[]) new Object[4 * arr.length];
    }

    public E get(int index) {
        if(index <0 || index >= data.length){
            throw new IllegalArgumentException("下标不合法");
        }
        return data[index];
    }

    public int getSize(){
        return data.length;
    }

    private int leftChild(int index){
        return 2 * index + 1;
    }

    private int rightChild(int index){
        return 2 * index + 2;
    }
}