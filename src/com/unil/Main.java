package com.unil;

import com.unil.element.Array;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Array array = new Array();
        array.addLast(10);
        array.addLast(8);
        array.addFirst(1);
        array.add(1,2);
        array.remove(1);
        System.out.println(array);
    }
}
