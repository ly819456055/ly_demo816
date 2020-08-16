package com.practice.practice.thread.zy;

import java.util.concurrent.CountDownLatch;

/**
 * 使用JUC辅助工具  完成线程的执行顺序
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(()-> {
                System.out.println(Thread.currentThread().getName() + "离开教室");
                //递减count值
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        //如果countDownLatch的count值还没有减完就等待
        countDownLatch.await();
        System.out.println("班长锁门");
    }
}
