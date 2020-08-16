package com.practice.practice.thread.zy;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 异步回调
 */
public class ComplateFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
//            System.out.println("没有返回值");
//        });
//        completableFuture.get();
        
        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(()->{
            System.out.println("有返回值");
            int num = 10/0;
            return 1024;
        });

        System.out.println( completableFuture2.whenComplete((t,u)-> {
            System.out.println("t:" + t);
            System.out.println("u:" + u);
        }).exceptionally((f)->{
            System.out.println("异常" + f.getMessage());
            return 4444;
        }).get());
    }
}
