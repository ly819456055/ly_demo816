package com.practice.practice.thread.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class WorkerThread extends Thread {

    BlockingQueue<String> taskQueue;

    public WorkerThread(BlockingQueue<String> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            String name;
            try {
                name = taskQueue.take();
            } catch (Exception e) {
                break;
            }
            System.out.println("name = " + name);
        }
    }
}

public class Main {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> taskQueue = new ArrayBlockingQueue<>(1000);
        WorkerThread workerThread = new WorkerThread(taskQueue);
        workerThread.start();
        taskQueue.put("张三");
        Thread.sleep(1000);
        taskQueue.put("李四");
        Thread.sleep(1000);
        taskQueue.put("王五");
        Thread.sleep(1000);
        workerThread.interrupt();
        workerThread.join();
        System.out.println("end");
    }

}
