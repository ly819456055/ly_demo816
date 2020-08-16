package com.practice.practice.design.factory;

/**
 * 苹果披萨
 */
public class ApplePizza extends Pizza {

    @Override
    public void prepare() {
        System.out.println("制作苹果披萨");
    }
}
