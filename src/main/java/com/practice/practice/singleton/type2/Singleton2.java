package com.practice.practice.singleton.type2;

public class Singleton2 {
    public static void main(String[] args) {
        Singleton22 singleton = Singleton22.getInstace();
        Singleton22 singleton2 = Singleton22.getInstace();
        System.out.println("------------->"+ singleton.hashCode());
        System.out.println("------------->"+ singleton2.hashCode());


    }


}

class Singleton22 {

    private Singleton22() {

    }

    private static Singleton22 instace;

    static {
        instace = new Singleton22();
    }

    public static Singleton22 getInstace() {
        return instace;
    }
}




