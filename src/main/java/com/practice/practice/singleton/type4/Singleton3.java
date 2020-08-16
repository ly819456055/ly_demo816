package com.practice.practice.singleton.type4;

public class Singleton3 {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstace();
        Singleton singleton2 = Singleton.getInstace();
        System.out.println("------------->"+ singleton.hashCode());
        System.out.println("------------->"+ singleton2.hashCode());
    }
}

class Singleton{
    //私有化构造方法
    private Singleton(){

    }
    //创建静态对象
    private static Singleton instace;

    public static synchronized Singleton getInstace(){
        if (instace == null){
            instace = new Singleton();
        }
        return instace;
    }
}
