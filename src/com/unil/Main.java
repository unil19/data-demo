package com.unil;

import com.unil.app.BracketCheck;
import com.unil.app.Student;
import com.unil.element.Queue;
import com.unil.element.Stack;
import com.unil.element.impl.*;

import static java.lang.System.nanoTime;
import static java.lang.System.out;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // write your code here
        Array<String> array = new Array<>();
        array.addLast("hello");
        array.addLast("world");
        array.addFirst("i");
        array.add(1, "am");
        array.remove(1);
        //System.out.println(arry);

        Array<Student> studentArray = new Array<>(2);
        Student student1 = new Student("liu", "100");
        Student student2 = new Student("li", "90");
        Student student3 = new Student("zhao", "76");
        studentArray.addLast(student1);
        studentArray.addLast(student2);
        studentArray.add(1, student3);
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

        Queue<Student> queue = new ArrayQueue<>();
        queue.enqueue(student1);
        queue.enqueue(student2);
//        System.out.println(queue);

        Queue<Student> loopQueue = new LoopQueue<>();
        loopQueue.enqueue(student1);
        loopQueue.enqueue(student2);
//        System.out.print(loopQueue.getFront());
//        double time1 = testQueue(new ArrayQueue<>(), 100000);
//        double time2 = testQueue(new LoopQueue<>(), 100000);
//        System.out.println("数组队列用时" + time1 + "ms");
//        System.out.print("循环队列用时" + time2 + "ms");
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        System.out.print(linkedList.toString());

    }

    public static double testQueue(Queue<Integer> queue, int count) {
        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < count; i++) {
            queue.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000;
    }
}
