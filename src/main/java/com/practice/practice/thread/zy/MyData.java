package com.practice.practice.thread.zy;

public class MyData {
    volatile int number = 0;

    public void addNumber(){
        number++;
    }

    public static void main(String[] args) {
        MyData mydata = new MyData();
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    mydata.addNumber();
                }
            },String.valueOf(i)).start();
        }
        //为什么大于2？  因为默认有一个main线程  还有一个jvm线程  如果大于2说明还有别的线程在运行
        while (Thread.activeCount()>2){
            //线程礼让  main线程让出cpu时间
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "number:" + mydata.number);
    }
}
