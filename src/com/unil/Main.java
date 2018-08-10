package com.unil;

import com.unil.app.Student;
import com.unil.element.Array;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Array<String> array = new Array<>();
        array.addLast("hello");
        array.addLast("world");
        array.addFirst("i");
        array.add(1,"am");
        array.remove(1);
        System.out.println(array);

        Array<Student> studentArray = new Array<>();
        Student student1 = new Student("liu", "100");
        Student student2 = new Student("li","90");
        Student student3 = new Student("zhao","76");
        studentArray.addLast(student1);
        studentArray.addLast(student2);
        studentArray.add(1,student3);
        System.out.println(studentArray);
    }
}