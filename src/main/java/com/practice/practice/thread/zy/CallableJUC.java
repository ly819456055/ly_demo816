package com.practice.practice.thread.zy;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class Mydata implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("~~~~~~come on~~~~~~");
        try { TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) { e.printStackTrace();}
        return 1024;
    }
}

/**
 * 第三种方式实现多线程
 *  通过实现Callable<>接口
 */
public class CallableJUC {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new Mydata());
        new Thread(futureTask,"A").start();
//        new Thread(futureTask,"B").start();
        System.out.println("主线程已计算完成");
        System.out.println(futureTask.get());
    }
}
