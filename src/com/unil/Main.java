package com.unil;

import com.unil.app.BracketCheck;
import com.unil.app.Student;
import com.unil.element.Stack;
import com.unil.element.impl.Array;
import com.unil.element.impl.ArrayStack;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        Array<String> array = new Array<>();
        array.addLast("hello");
        array.addLast("world");
        array.addFirst("i");
        array.add(1,"am");
        array.remove(1);
        //System.out.println(arry);

        Array<Student> studentArray = new Array<>(2);
        Student student1 = new Student("liu", "100");
        Student student2 = new Student("li","90");
        Student student3 = new Student("zhao","76");
        studentArray.addLast(student1);
        studentArray.addLast(student2);
        studentArray.add(1,student3);
        studentArray.addLast(student1);
        studentArray.addLast(student1);
        studentArray.removeLast();
        //System.out.println(studentArray);

        //同步锁测试
//        CounterRunner counterRunner = new CounterRunner();
//        RandomRunner randomRunner = new RandomRunner();
//        Thread thread1 = new Thread(counterRunner);
//        Thread thread2 = new Thread(randomRunner);
//        thread1.start();
//        thread2.start();


        Stack<Student> studentStack = new ArrayStack<>();
        studentStack.push(student1);
        studentStack.push(student2);
        studentStack.pop();
        //System.out.println(studentStack);

        //栈的应用：括号检查
        String trueStr = "[sdsda{(sdsaxc)fgfg}cvxcvcx你好]";
        String falseStr = "[hello{world]你好}世界(程序员)";
//        System.out.println(BracketCheck.check(trueStr));
//        System.out.println(BracketCheck.check(falseStr));

    }
}
