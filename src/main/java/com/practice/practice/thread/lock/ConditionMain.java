package com.practice.practice.thread.lock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.*;

class TaskQueue{

    final Queue<String> queue = new LinkedList<>();
    //获取锁对象  向上转型
    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public String getTask() throws InterruptedException {
        lock.lock();
        try {
            while (this.queue.isEmpty()){
                //线程等待
                condition.await();
            }
            return queue.remove();
        }finally {
            lock.unlock();
        }
    }

    public void addTask(String name){
        //加锁
        lock.lock();
        try {
            this.queue.add(name);
            //释放锁
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

}

class ConditionThread extends Thread{
    TaskQueue taskQueue;

    public ConditionThread(TaskQueue taskQueue){
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        //判断当前线程是否已中断
        while (!isInterrupted()){
            String name;
            try {
                name = taskQueue.getTask();
            }catch (Exception e){
                break;
            }
            System.out.println("name = " + name);
        }
    }
}


public class ConditionMain{

    private final static int LOOP = 100;

    public static void main(String[] args) throws InterruptedException {
        TaskQueue taskQueue = new TaskQueue();
        ConditionThread conditionThread = new ConditionThread(taskQueue);
        conditionThread.start();
        taskQueue.addTask("张三");
        Thread.sleep(1000);
        taskQueue.addTask("李四");
        Thread.sleep(1000);
        taskQueue.addTask("王五");
        Thread.sleep(1000);
        conditionThread.interrupt();
        conditionThread.join();
        System.out.println("End");
    }
}
