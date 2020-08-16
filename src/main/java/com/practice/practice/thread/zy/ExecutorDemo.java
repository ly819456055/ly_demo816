package com.practice.practice.thread.zy;

import java.util.concurrent.*;

/**
 * 线程池的使用
 */
public class ExecutorDemo {
    public static void main(String[] args) {
//        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService executorService = new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.SECONDS,new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        try {
            for (int i = 1; i <= 20; i++) {
                executorService.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "\t办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    private static void ExecutorDemo() {
        ExecutorService executor = Executors.newFixedThreadPool(5);
//        ExecutorService executorService = new ThreadPoolExecutor();
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        ExecutorService executor = Executors.newCachedThreadPool();
        try {
            for (int i = 1; i <= 10; i++) {
                try { TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) { e.printStackTrace();}
                executor.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "\t办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
