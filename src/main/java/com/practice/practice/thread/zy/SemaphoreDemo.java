package com.practice.practice.thread.zy;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 通过Semaphore信号灯
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        //获取Semaphore对象
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "停车");
                    try { TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) { e.printStackTrace();}
                    System.out.println(Thread.currentThread().getName() + "离开");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
