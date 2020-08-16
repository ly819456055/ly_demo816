package com.practice.practice.singleton.type6;

public class Singleton6 {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println("------------->"+ singleton.hashCode());
        System.out.println("------------->"+ singleton2.hashCode());
    }

}

class Singleton{

    private Singleton(){

    }

    private static volatile Singleton instance;

    private static class SingletonInterlor{
        public static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonInterlor.INSTANCE;
    }

}
