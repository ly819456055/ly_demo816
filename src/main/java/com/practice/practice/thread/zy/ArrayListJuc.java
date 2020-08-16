package com.practice.practice.thread.zy;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 资源类
 */
class Ticket {
    private int number = 30;
    //定义一个可重入锁
    private Lock lock = new ReentrantLock();

//    public synchronized void selectTicket() {
//        if (number > 0) {
//            System.out.println(Thread.currentThread().getName() + "卖出第：" + number-- + "张票，还剩" + number + "张票。");
//        }
//    }

    //使用lock锁的方式来实现同步
    public void selectTicket() {
        //获取锁
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出第：" + number-- + "张票，还剩" + number + "张票。");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放锁
            lock.unlock();
        }

    }
}

/**
 * 线程操作资源类
 * i--的意思是使用完之后再-1
 */
public class ArrayListJuc {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        //通过Lambad表达式实现线程
        new Thread(() -> {for (int i = 1; i <= 40; i++)ticket.selectTicket();},"A").start();
        new Thread(() -> {for (int i = 1; i <= 40; i++)ticket.selectTicket();},"B").start();
        new Thread(() -> {for (int i = 1; i <= 40; i++)ticket.selectTicket();},"C").start();

        //new一个线程 通过new线程接口匿名内部类
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 1; i <= 40; i++) {
//                    ticket.selectTicket();
//                }
//            }
//        }, "A").start();
//
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 1; i <= 40; i++) {
//                    ticket.selectTicket();
//                }
//            }
//        }, "B").start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 1; i <= 40; i++) {
//                    ticket.selectTicket();
//                }
//            }
//        }, "C").start();

    }
}
