package com.practice.practice.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Counter{
    //获取锁对象  向上转型
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private Lock rlock = readWriteLock.readLock();

    private Lock wlock = readWriteLock.writeLock();

    private int value = 0;

    public void add(int num){
        wlock.lock();
        try {
            this.value += num;
        }finally {
            wlock.unlock();
        }
    }

    public void dec(int num){
        wlock.lock();
        try {
            this.value -= num;
        }finally {
            wlock.unlock();
        }
    }

    public int get(){
        rlock.lock();
        try {
            return this.value;
        }finally {
            rlock.unlock();
        }
    }
}

public class Main{

    private final static int LOOP = 100;

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new Thread(){
            public void run() {
                for (int i = 0; i < LOOP; i++) {
                    counter.add(1);
                }
            }
        };

        Thread t2 = new Thread(){
            public void run() {
                for (int i = 0; i < LOOP; i++) {
                    counter.dec(1);
                }
            }
        };

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.get());
    }
}
