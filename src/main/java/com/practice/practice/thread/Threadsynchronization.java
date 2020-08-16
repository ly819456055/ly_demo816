package com.practice.practice.thread;


class Counter {
    int count = 0;

    public synchronized void add(int n){
        count += n;
    }

    public synchronized void dec(int n){
        count -= n;
    }

   public int get(){
        return count;
   }
}

class ThreadA extends Thread{

    public Counter counter;

    public ThreadA(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < Threadsynchronization.LOOP; i++) {
            counter.add(1);
        }
    }
}

class ThreadB extends Thread{

    public Counter counter;

    public ThreadB(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < Threadsynchronization.LOOP; i++) {
            counter.dec(1);
        }
    }
}


public class Threadsynchronization {
    final static int LOOP = 10000;

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new ThreadA(counter);
        Thread t2 = new ThreadB(counter);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.get());
        System.out.println("Thread end");
    }
}
