package com.practice.practice.thread.zy;

import java.util.concurrent.TimeUnit;

class Phone{
    public static synchronized void sendEmail(){
        try { TimeUnit.SECONDS.sleep(4);} catch (InterruptedException e) { e.printStackTrace();}
        System.out.println("sendEmail");
    }

    public static synchronized void sendSMS(){
        System.out.println("sendSMS");
    }

    public void hello(){
        System.out.println("hello");
    }
}

public class Lock8 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        Phone phone2 = new Phone();

        new Thread(()-> {
            phone.sendEmail();
        },"A").start();

        Thread.sleep(100);

        new Thread(()-> {
//            phone.sendSMS();
//            phone.hello();
            phone2.sendSMS();
        },"B").start();

//        new Thread(()-> {
//            phone.hello();
//        },"C").start();


    }
}
