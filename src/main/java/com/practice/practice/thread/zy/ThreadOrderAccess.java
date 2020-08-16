package com.practice.practice.thread.zy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 资源类
 * 通过condition完成线程间的精准定位  精准唤醒
 */
class ShareResource{
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();



    public void print5(){
        lock.lock();
        try {
            while (number != 1){
                condition1.await();
            }
            //执行业务
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            number = 2;
            condition2.signal();
        } catch (Exception e) {
        e.printStackTrace();
        } finally {
        lock.unlock();
        }
    }

    public void print10(){
        lock.lock();
        try {
            while (number != 2){
                condition2.await();
            }
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            number = 3;
            condition3.signal();
        } catch (Exception e) {
        e.printStackTrace();
        } finally {
        lock.unlock();
        }
    }

    public void print15(){
        lock.lock();
        try {
            while (number != 3){
                condition3.await();
            }
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            number = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }



}

public class ThreadOrderAccess {
    public static void main(String[] args) {
//        ShareResource shareResource = new ShareResource();
//        new Thread(() -> {for (int i = 1; i <= 10; i++) shareResource.print5();},"A").start();
//        new Thread(() -> {for (int i = 1; i <= 10; i++) shareResource.print10();},"B").start();
//        new Thread(() -> {for (int i = 1; i <= 10; i++) shareResource.print15();},"C").start();
        Map<String,String> map = new HashMap<>();
        map.put("a","zhangsan");
        map.put("b","lisi");
        for (String key:map.keySet()) {
            System.out.println("key是：" + key + "\tvalue是：" + map.get(key));
        }
    }
}
