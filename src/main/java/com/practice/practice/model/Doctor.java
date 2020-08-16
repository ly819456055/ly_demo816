package com.practice.practice.model;

/**
 * 人实体类
 */
public class Doctor extends Father{
    private String name;
    private String sex = "我是男生";
    private Integer age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void playGame(){
        System.out.println("我在玩游戏");
    }
}
