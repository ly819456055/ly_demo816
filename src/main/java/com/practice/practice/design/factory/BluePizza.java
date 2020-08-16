package com.practice.practice.design.factory;

/**
 * 蓝色披萨
 */
public class BluePizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("制作蓝色披萨");
    }
}
