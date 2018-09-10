package com.unil.element.impl;

import com.unil.element.Stack;

/**
 * @author liuwh33
 * @date 2018/9/8 14:02
 * @desc
 */
public class ArrayStack<E> implements Stack<E>{

    Array<E> array;

    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayStack(){
        array = new Array<>();
    }

    @Override
    public void push(E element) {
        array.addLast(element);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "array=" + array +
                '}';
    }
}