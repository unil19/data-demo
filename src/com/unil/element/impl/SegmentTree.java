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

    public E query(int queryBegin, int queryEnd){
        if(queryBegin<0||queryEnd>data.length||queryBegin>queryEnd){
            throw new IllegalArgumentException("请求端点不正确");
        }
        return query(0, 0, data.length -1, queryBegin, queryEnd);
    }
    private E query(int treeIndex, int treeBegin, int treeEnd, int queryBegin, int queryEnd){
        if(treeBegin == queryBegin && treeEnd == queryEnd) {
            return tree[treeIndex];
        }
        int leftChildIndex = leftChild(treeIndex);
        int rightChildIndex = rightChild(treeIndex);
        int middle = treeBegin + (treeEnd - treeBegin)/2;
        if(queryEnd<=middle) {
            return query(leftChildIndex, treeBegin, middle, queryBegin, queryEnd);
        }
        if(queryBegin>middle){
            return query(rightChildIndex, middle + 1, treeEnd, queryBegin, queryEnd);
        }
        E leftPart = query(leftChildIndex, treeBegin, middle, queryBegin, middle);
        E rightPart = query(rightChildIndex, middle + 1, treeEnd, middle + 1, queryEnd);
        return merger.merge(leftPart, rightPart);
    }
    public E get(int index) {
        if(index <0 || index >= data.length){
            throw new IllegalArgumentException("下标不合法");
        }
        return data[index];
    }

    public void set(int index, E e) {
        if(index <0 || index >= data.length){
            throw new IllegalArgumentException("下标不合法");
        }
        data[index] =  e;
        set(0, 0, data.length - 1, index, e);
    }

    private void set(int treeIndex, int treeBegin, int treeEnd, int dataIndex, E e){
        if(treeBegin == treeEnd) {
            tree[treeIndex] = e;
            return;
        }
        int leftChildIndex = leftChild(treeIndex);
        int rightChildIndex = rightChild(treeIndex);
        int middle = treeBegin + (treeEnd - treeBegin)/2;
        if(dataIndex<=middle) {
            set(leftChildIndex, treeBegin, middle, dataIndex, e);
        }
        if(dataIndex>middle){
            set(rightChildIndex, middle + 1, treeEnd, dataIndex, e);
        }
        tree[treeIndex] = merger.merge(tree[leftChildIndex], tree[rightChildIndex]);
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
