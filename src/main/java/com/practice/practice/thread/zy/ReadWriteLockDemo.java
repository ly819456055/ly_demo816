package com.practice.practice.thread.zy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyDataDemo{
    private volatile Map<String,Object> map = new HashMap<>();

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void putNumber(String key,Object value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "开始写入" + key);
            try { TimeUnit.MILLISECONDS.sleep(300);} catch (InterruptedException e) { e.printStackTrace();}
            map.put(key,value);
            System.out.println(Thread.currentThread().getName() + "写入完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }

    public void getNumber(String key){
        try {
            readWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + "开始读取" + key);
            try { TimeUnit.MILLISECONDS.sleep(300);} catch (InterruptedException e) { e.printStackTrace();}
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取完成" + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }

    }
}

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyDataDemo myDataDemo = new MyDataDemo();
        for (int i = 1; i <= 5; i++) {
            final int num = i;
            new Thread(()->{
                myDataDemo.putNumber(num + "",num + "");
            },String.valueOf(i)).start();
        }
        for (int i = 1; i <= 5; i++) {
            final int num = i;
            new Thread(()->{
                myDataDemo.getNumber(num + "");
            },String.valueOf(i)).start();
        }
    }
}
