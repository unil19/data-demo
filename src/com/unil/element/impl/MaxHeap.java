package com.unil.element.impl;

public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        int maxIndex = data.getSize() - 1;
        int maxBranchIndex = parent(maxIndex);
        for(int i = maxBranchIndex; i>=0;i--){
            siftDown(i);
        }
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
        siftUp(size()-1);
    }

    private void siftUp(int index){
        while (index>0&&data.get(index).compareTo(data.get(parent(index)))>0){
            data.swap(index, parent(index));
            index = parent(index);
        }
    }

    public E getMax(){
        if(size()==0){
            throw new IllegalArgumentException("堆为空, 不能获取最大值");
        }
        return data.get(0);
    }

    public E extractMax(){
        E max = getMax();
        data.swap(0, data.getSize()-1);
        data.removeLast();
        siftDown(0);
        return max;
    }

    public E replace(E e){
        E max = getMax();
        data.set(0, e);
        siftDown(0);
        return max;
    }

    private void siftDown(int index) {
        while (leftChild(index)<size()){
            int leftChildIndex = leftChild(index);
            int rightChildIndex = leftChildIndex + 1;
            int maxChildIndex = rightChildIndex>=size()?leftChildIndex:
                    data.get(leftChildIndex).compareTo(data.get(rightChildIndex))>=0?leftChildIndex:rightChildIndex;
            if(data.get(index).compareTo(data.get(maxChildIndex))>=0) {
                break;
            }
            data.swap(index, maxChildIndex);
            index = maxChildIndex;
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
