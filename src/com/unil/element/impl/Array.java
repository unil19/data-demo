package com.unil.element.impl;

/**
 * @author liuwh33
 * @date 2018/8/6 20:08
 * @desc
 */
public class Array<T> {

    private int size;
    private T[] data;

    /**
     * 初始化容量的构造函数
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("数组下标方法");
        }
        return data[index];
    }

    public T getLast(){
        return get(size - 1);
    }

    public T getFirst(){
        return get(0);
    }

    public void set(int index, T value) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("数组下标方法");
        }
        data[index] = value;
    }

    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(T value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("数组下标方法");
        }
        T oldData = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        ;
        data[size - 1] = null;
        size--;
        if(size <= data.length/4 && data.length/2!=0){
            resize(data.length/2);
        }
        return oldData;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(size - 1);
    }

    public boolean removeElement(T value) {
        int index = indexOf(value);
        if (-1 != index) {
            remove(index);
            return true;
        }
        return false;
    }

    public void addLast(T ele) {
        add(size, ele);
    }

    public void addFirst(T ele) {
        add(0, ele);
    }

    public void add(int index, T ele) {
        if (size >= data.length) {
            resize(2*data.length);
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index不合法，不能添加");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = ele;
        size++;
    }

    private void resize(int length){
        T[] newData = (T[]) new Object[length];
        for(int i=0; i<size;i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array size:%d, capacity:%d\n", size, getCapacity()));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(data[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
