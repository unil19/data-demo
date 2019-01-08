package com.unil;

import com.unil.app.BracketCheck;
import com.unil.app.Student;
import com.unil.element.*;
import com.unil.element.impl.*;

import java.util.Random;

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
        Queue<Student> linkedQueue = new LinkedListQueue<>();
        linkedQueue.enqueue(student1);
        linkedQueue.enqueue(student2);
//        double time1 = testQueue(new ArrayQueue<>(), 100000);
//        double time2 = testQueue(new LoopQueue<>(), 100000);
//        double time3 = testQueue(new LinkedListQueue<>(), 100000);
//        System.out.println("数组队列用时" + time1 + "ms\n");
//        System.out.print("循环队列用时" + time2 + "ms\n");
//        System.out.print("链表队列用时" + time3 + "ms\n");
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        linkedList.addFirst(1);
//        linkedList.addFirst(2);
//        linkedList.add(2,8);
//        linkedList.set(1, 66);
//        linkedList.remove(1);
//        System.out.print(linkedList.toString());
//        LinkedListStack<Integer> stack = new LinkedListStack<>();
//        stack.push(1);
//        stack.push(2);
//        System.out.print(stack.pop());
//        double time3 = testStack(new ArrayStack<>(), 100000);
//        double time4 = testStack(new LinkedListStack<>(), 100000);
//        System.out.println("数组栈用时" + time3 + "ms");
//        System.out.print("链表栈用时" + time4 + "ms");

//        BST<Integer> bst = new BST<>();
//        int[] data = {5,3,6,8,4,2};
//        for(int i = 0;i<data.length;i++){
//            bst.add(data[i]);
//        }
//        int e = 11;
//        boolean isContain = bst.contains(e);
//        System.out.print("二分搜索树中"+ (isContain?"":"不")+"包含"+e);

//        bst.preOrder();
//        System.out.print("\n");
//        bst.inOrder();
//        System.out.print("\n");
//        bst.postOrder();
//        System.out.print("\n");
//        bst.levelOrder();
        System.out.print("\n");
//        System.out.print(bst.toString());
//        System.out.print(bst.maximum());
//        bst.removeMin();
//        bst.removeMax();
//        bst.remove(8);
//        System.out.print(bst.toString());

//        LinkedList<Integer> linkedList = new LinkedList<>();
//        linkedList.addFirst(4);
//        linkedList.addFirst(3);
//        linkedList.addFirst(2);
//        linkedList.addFirst(5);
//        linkedList.addFirst(2);
//        linkedList.removeElement(2);
//        System.out.print(linkedList.toString());
        //集合测试
//        BSTSet<Integer> bstSet = new BSTSet<>();
//        LinkedListSet<Integer> linkedListSet = new LinkedListSet<>();
//        int testNum = 20000;
//        Double bstTime = testSet(bstSet, testNum);
//        System.out.print("二分搜索树Set时间"+bstTime+"毫秒");
//        System.out.print("\n");
//        Double linkedListTime = testSet(linkedListSet, testNum);
//        System.out.print("链表Set时间"+linkedListTime+"毫秒");

//        System.out.println("hello");
//        LinkedListMap<String, String> linkedListMap = new LinkedListMap<>();
//        linkedListMap.add("d", "六");
//        linkedListMap.add("a", "百");
//        linkedListMap.add("v", "里");
//        linkedListMap.add("i", "加");
//        linkedListMap.add("d", "急");
//        System.out.println(linkedListMap.get("d"));

//        BSTMap<Integer, Integer> bstMap = new BSTMap<>();
//        LinkedListMap<Integer, Integer> linkedListMap = new LinkedListMap<>();
//        int testNum = 20000;
//        Double bstTime = testMap(bstMap, testNum);
//        System.out.print("二分搜索树Map时间"+bstTime+"毫秒");
//        System.out.print("\n");
//        Double linkedListTime = testMap(linkedListMap, testNum);
//        System.out.print("链表Map时间"+linkedListTime+"毫秒");

//        int n = 100;
//        MaxHeap<Integer> maxHeap = new MaxHeap<>();
//        Random random = new Random();
//        for(int i =0; i<n;i++){
//            maxHeap.add(random.nextInt(10000));
//        }
//        Array<Integer> arr = new Array<>();
//        for(int i =0; i<n;i++){
//            arr.addLast(maxHeap.extractMax());
//        }
//        System.out.println(arr.toString());
        Integer[] arr = {0,1,2,3,4,5,6,7,8,9};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(arr, (a, b)-> a+b);
        segmentTree.set(0, 10);
        System.out.println(segmentTree.toString());

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

    public static double testStack(Stack<Integer> stack, int count) {
        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            stack.push(i);
        }
        for (int i = 0; i < count; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000;
    }

    public static double testSet(Set<Integer> set, int count) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            set.add(random.nextInt(count/2));
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000;
    }

    public static double testMap(Map<Integer, Integer> map, int count) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            map.add(random.nextInt(count/2), random.nextInt(count/2));
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000;
    }
}
