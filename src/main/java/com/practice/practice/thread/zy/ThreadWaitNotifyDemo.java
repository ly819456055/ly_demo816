package com.practice.practice.thread.zy;

class AirConditioner{
    private int num = 0;

    //生产者
    public synchronized void increment(){
        while (num != 0){
            try {
                //等待 睡眠 不占有锁。
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num++;
        //释放锁，通知其他线程可以唤醒了
        System.out.println(Thread.currentThread().getName() + "\t" + num);
        this.notifyAll();
    }

    //消费者
    public synchronized void decrement(){
        while (num == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num--;
        System.out.println(Thread.currentThread().getName() + "\t" + num);
        this.notifyAll();
    }
}

public class ThreadWaitNotifyDemo {

    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();
        new Thread(() -> {for (int i = 1; i <= 10; i++) airConditioner.increment();},"A").start();
        new Thread(() -> {for (int i = 1; i <= 10; i++) airConditioner.decrement();},"B").start();
        new Thread(() -> {for (int i = 1; i <= 10; i++) airConditioner.increment();},"C").start();
        new Thread(() -> {for (int i = 1; i <= 10; i++) airConditioner.decrement();},"D").start();
    }


}
