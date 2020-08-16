package com.practice.practice.design.absFactory.factory;

/**
 * 苹果披萨
 */
public class BJApplePizza extends Pizza {


    @Override
    public void prepare() {
        setName("北京披萨");
        System.out.println("北京苹果披萨");
    }
}
