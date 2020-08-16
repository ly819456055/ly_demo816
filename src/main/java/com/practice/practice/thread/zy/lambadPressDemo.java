package com.practice.practice.thread.zy;

interface Foo{
    public void sayHello();
}

public class lambadPressDemo {
    public static void main(String[] args) {
//        Foo foo = new Foo() {
//            @Override
//            public void sayHello() {
//                System.out.println("hello lambad");
//            }
//        };
//        foo.sayHello();
        Foo foo = () -> {System.out.println("hello lambad");};
        foo.sayHello();
    }
}
