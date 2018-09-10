package com.unil.element;

/**
 * @author liuwh33
 * @date 2018/9/8 13:56
 * @desc
 */
public interface Stack<E> {

    /**
     * 入栈
     * @param element
     */
    void push(E element);

    /**
     * 出栈
     */
    E pop();

    /**
     * 查看栈顶
     * @return
     */
    E peek();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 查看栈的容量
     * @return
     */
    int getSize();


}
