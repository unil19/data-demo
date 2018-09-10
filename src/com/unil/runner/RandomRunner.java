package com.unil.runner;

/**
 * @author liuwh33
 * @date 2018/9/6 13:49
 * @desc
 */
public class RandomRunner implements Runnable{
    @Override
    public void run() {
        synString2(new String("liuwh"));
    }

    public static void synString(String userId) {

        synchronized (userId){
            System.out.println("线程2");
        }
    }
    public static void synString2(Object userId) {

        synchronized (userId.toString().intern()){
            System.out.println("线程2");
        }
    }
}
