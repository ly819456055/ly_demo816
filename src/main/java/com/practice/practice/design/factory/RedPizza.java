package com.practice.practice.design.factory;

/**
 * 红色披萨
 */
public class RedPizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("制作红色披萨");
    }
}
