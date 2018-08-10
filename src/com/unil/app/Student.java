package com.unil.app;

/**
 * @author liuwh33
 * @date 2018/8/10 20:40
 * @desc
 */
public class Student {

    private String name;
    private String score;

    public Student(){

    }
    public Student(String name, String score) {
        this.name = name;
        this.score = score;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
