package com.unil.element.impl;

import com.unil.element.Queue;

/**
 * @author liuwh33
 * @date 2018/9/12 18:15
 * @desc
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;


    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayQueue(){
        array = new Array<>();
    }
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "array=" + array +
                '}';
    }
}
