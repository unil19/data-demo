package com.unil.element;

/**
 * @author liuwh33
 * @date 2018/9/10 20:25
 * @desc
 */
public interface Queue<E> {

    void enqueue(E e);

    E dequeue();

    E getFront();

    int getSize();

    boolean isEmpty();

}
