package com.unil.element;

/**
 * @author liuwh33
 * @date 2018/8/6 20:08
 * @desc
 */
public class Array {

    private int size;
    private int[] data;

    /**
     * 初始化容量的构造函数
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = new int[capacity];
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

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("数组下标方法");
        }
        return data[index];
    }

    public void set(int index, int value) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("数组下标方法");
        }
        data[index] = value;
    }

    public boolean contains(int value) {
        for (int i = 0; i < size; i++) {
            if (value == data[i]) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (value == data[i]) {
                return i;
            }
        }
        return -1;
    }

    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("数组下标方法");
        }
        int oldData = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        ;
        data[size - 1] = 0;
        size--;
        return oldData;
    }

    public int removeFirst() {
        return remove(0);
    }

    public int removeLast() {
        return remove(size - 1);
    }

    public boolean removeElement(int value) {
        int index = indexOf(value);
        if (-1 != index) {
            remove(index);
            return true;
        }
        return false;
    }

    public void addLast(int ele) {
        add(size, ele);
    }

    public void addFirst(int ele) {
        add(0, ele);
    }

    public void add(int index, int ele){
        if (size >= data.length) {
            throw new IllegalArgumentException("数组已满，不能继续添加");
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
