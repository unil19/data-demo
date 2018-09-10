package com.unil.runner;


/**
 * @author liuwh33
 * @date 2018/9/6 10:55
 * @desc
 */
public class CounterRunner implements Runnable{

    static int counts = 0;

    @Override
    public void run() {
        try {
            synString2(new String("liuwh"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void increase(){
        for(int i=0; i<10000; i++) {
            counts++;
        }
    }

    public static void synString(String userId) throws InterruptedException {
        synchronized (userId){
            System.out.println("线程1");
            Thread.sleep(5000);
        }
    }

    public static void synString2(Object object) throws InterruptedException {
        synchronized (object.toString().intern()){
            System.out.println("线程1");
            Thread.sleep(5000);
        }
    }

    public static void main(String[] argus) throws InterruptedException {
        CounterRunner counterRunner = new CounterRunner();
        for(int i=0;i<1000;i++) {
            Thread thread = new Thread(counterRunner);
            thread.start();
            thread.join();
        }
        System.out.println(counts);
    }
}
