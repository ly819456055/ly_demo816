package com.practice.practice.design.factoryMethod.factory;

/**
 * 蓝色披萨
 */
public class BJBluePizza extends Pizza {

    @Override
    public void prepare() {
        setName("北京披萨");
        System.out.println("北京蓝色披萨");
    }
}
