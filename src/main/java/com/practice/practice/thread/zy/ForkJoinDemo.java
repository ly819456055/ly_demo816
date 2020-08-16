package com.practice.practice.thread.zy;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

    class MydataDemoTest extends RecursiveTask<Integer> {
    private final int NUMBER = 10;
    private int begin;
    private int end;
    private int result;

    public MydataDemoTest(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }
    @Override
    protected Integer compute() {
        if ((end - begin) <= NUMBER){
            for (int i=begin;i<end; i++){
                result = result+i;
            }
        }else {
            int middle = (end + begin)/2;
            MydataDemoTest mydata = new MydataDemoTest(begin,middle);
            MydataDemoTest mydata2 = new MydataDemoTest(middle+1,end);
            mydata.fork();
            mydata2.fork();
            result = mydata.join() + mydata2.join();
        }
        return result;
    }
}
//合并分值线程池
public class ForkJoinDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MydataDemoTest demoTest = new MydataDemoTest(0,100);
            ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(demoTest);
        System.out.println(forkJoinTask.get());
    }

}
