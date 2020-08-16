package com.practice.practice.model;

public class Father {
    public String name;
    private static String sex = "我是女生";

    public Father() {
    }

    public Father(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void playGame(){
        System.out.println("我在打球");
    }

    public void getSex(){
        System.out.println(sex);
    }
}
