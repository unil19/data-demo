package com.unil.element.impl;

import com.unil.element.Merger;

import java.util.Arrays;

public class SegmentTree<E>{
    private E[] tree;
    private E[] data;
    private Merger<E> merger;
    public SegmentTree(E[] arr, Merger<E> merger){
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        for(int i=0;i<arr.length;i++){
            data[i] = arr[i];
        }
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    private void buildSegmentTree(int treeIndex, int begin, int end){
         if(begin==end){
             tree[treeIndex] = data[begin];
             return;
         }
         int leftChildIndex = leftChild(treeIndex);
         int rightChildIndex = rightChild(treeIndex);
         int middle = begin + (end - begin)/2;
         buildSegmentTree(leftChildIndex, begin, middle);
         buildSegmentTree(rightChildIndex, middle + 1, end);
         tree[treeIndex] = merger.merge(tree[leftChildIndex], tree[rightChildIndex]);
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

    @Override
    public String toString() {
        return "SegmentTree{" +
                "tree=" + Arrays.toString(tree) +
                '}';
    }
}
