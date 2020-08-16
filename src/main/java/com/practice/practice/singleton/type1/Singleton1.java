package com.practice.practice.singleton.type1;

public class Singleton1 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstace();
        Singleton singleton2 = Singleton.getInstace();
        System.out.println("------------->"+ singleton.hashCode());
        System.out.println("------------->"+ singleton2.hashCode());

    }


}

class Singleton {

    private Singleton() {

    }

    private final static Singleton instace = new Singleton();

    public static Singleton getInstace() {
        return instace;
    }
}




