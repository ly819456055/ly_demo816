package com.practice.practice.thread;

/**
 * 线程实现的方法 1.继承Thread线程类
 */
public class MyThread extends Thread{

    @Override
    public void run() {
//        while (!isInterrupted()){
//            System.out.println("hello!");
//            try {
//                Thread.sleep(100);
//            }catch (InterruptedException e){
//                System.out.println("isInterrupted!");
//                break;
//            }
//        }
//        System.out.println("thread end");

        while (true){
            System.out.println("hello!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        final int LOOP = 10000;
        MyThread t = new MyThread();
        t.setDaemon(true);
        t.start();
        Thread.sleep(5000);
//        t.interrupt();
        System.out.println("Main end");
    }
}
