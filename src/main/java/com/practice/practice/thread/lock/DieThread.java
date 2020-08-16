package com.practice.practice.thread.lock;

class ThreadTest {

    final Object lockA = new Object();
    final Object lockB = new Object();

    int accountA = 1000;
    int accountB = 2000;

    public void a2b(int balance){
        synchronized (lockA){
            accountA -= balance;
            synchronized (lockB){
             accountB += balance;
            }
        }
    }

    public void b2a(int balance){
        synchronized (lockA){
            accountB += balance;
            synchronized (lockB){
                accountA -= balance;
            }
        }
    }
}

class ThreadA extends Thread{
    public void run() {
        for (int i = 0; i < DieThread.LOOP; i++) {
            DieThread.threadTest.a2b(1);
            if (i % 100 == 0){
                System.out.println(".");
            }
        }
    }
}

class ThreadB extends Thread{
    public void run() {
        for (int i = 0; i < DieThread.LOOP; i++) {
            DieThread.threadTest.b2a(1);
            if (i % 100 == 0){
                System.out.println(".");
            }
        }
    }
}

public class DieThread{
    final static int LOOP = 1000;

    public static ThreadTest threadTest = new ThreadTest();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new ThreadA();
        Thread t2 = new ThreadB();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("执行完毕");
    }
}
