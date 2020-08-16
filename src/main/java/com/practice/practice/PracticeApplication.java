package com.practice.practice;

import com.practice.practice.thread.MyThread;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import sun.applet.AppletListener;

@SpringBootApplication
public class PracticeApplication implements ApplicationListener<ApplicationReadyEvent> {

    public static void main(String[] args) {
        SpringApplication.run(PracticeApplication.class, args);
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationEvent) {
        Runnable r = new MyThread();
        Thread t = new Thread(r);
        t.run();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
