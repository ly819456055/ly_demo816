package com.practice.practice.thread.zy;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
//        System.out.println(blockingQueue.add("a"));
//        System.out.println(blockingQueue.add("b"));
//        System.out.println(blockingQueue.element());
//        System.out.println(blockingQueue.add("d"));
//        System.out.println(blockingQueue.remove("b"));
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());

//        System.out.println(blockingQueue.offer("a"));
//        System.out.println(blockingQueue.offer("b"));
//        System.out.println(blockingQueue.offer("c"));
////        System.out.println(blockingQueue.offer("d"));
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());

//        blockingQueue.put("a");
//        blockingQueue.take();
//        blockingQueue.put("b");
//        blockingQueue.take();
//        blockingQueue.put("c");
//        blockingQueue.put("d");
//
//        blockingQueue.take();
//        blockingQueue.take();
//        blockingQueue.take();

        System.out.println(blockingQueue.offer("a", 3,TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 3,TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 3,TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 3,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.offer("b", 3,TimeUnit.SECONDS));
    }
}
