package com.practice.practice.thread.wait;

import java.util.LinkedList;
import java.util.Queue;

class TaskQueue{

    final Queue<String> queue = new LinkedList<>();

    public synchronized String getTask() throws InterruptedException {
        while (this.queue.isEmpty()){
            this.wait();
        }
        return queue.remove();
    }

    public synchronized void addTask(String name){
        this.queue.add(name);
        this.notifyAll();
    }
}

class WorkerThread extends Thread{
    TaskQueue taskQueue;

    public WorkerThread(TaskQueue taskQueue){
        this.taskQueue = taskQueue;
    }

    public void run() {
        while (!isInterrupted()){
            String name;
            try {
                name = taskQueue.getTask();
            } catch (InterruptedException e) {
                break;
            }
            System.out.println("hello" + name);
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TaskQueue taskQueue = new TaskQueue();
        WorkerThread workerThread = new WorkerThread(taskQueue);
        workerThread.start();
        taskQueue.addTask("张三");
        Thread.sleep(1000);
        taskQueue.addTask("李四");
        Thread.sleep(1000);
        taskQueue.addTask("王五");
        Thread.sleep(1000);
        workerThread.interrupt();
        workerThread.join();//结束线程
        System.out.println("end");
    }
}
