package com.practice.practice.thread.zy;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class CakeShop{
    private int number = 0;
    //定义一个锁对象
    private Lock lock = new ReentrantLock();
    //定义一个Condition
    private Condition condition = lock.newCondition();

    public void increment(){
        lock.lock();
        try {
            while (number != 0){
                //交出锁，等同wait
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + ":\t" + number);
            condition.signalAll();
        } catch (Exception e) {
        e.printStackTrace();
        } finally {
        lock.unlock();
        }
    }

    public void decrement(){
        lock.lock();
        try {
            while(number == 0){
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + ":\t" + number);
            condition.signalAll();
        } catch (Exception e) {
        e.printStackTrace();
        } finally {
        lock.unlock();
        }
    }
}

public class ConditionThreadDemo {
    public static void main(String[] args) {
        CakeShop cakeShop = new CakeShop();
        new Thread(() -> {for (int i = 1; i <= 10; i++) cakeShop.increment();},"A").start();
        new Thread(() -> {for (int i = 1; i <= 10; i++) cakeShop.decrement();},"B").start();
        new Thread(() -> {for (int i = 1; i <= 10; i++) cakeShop.increment();},"C").start();
        new Thread(() -> {for (int i = 1; i <= 10; i++) cakeShop.decrement();},"D").start();
    }
}
