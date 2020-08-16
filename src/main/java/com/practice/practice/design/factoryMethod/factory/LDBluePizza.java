package com.practice.practice.design.factoryMethod.factory;

/**
 * 蓝色披萨
 */
public class LDBluePizza extends Pizza {

    @Override
    public void prepare() {
        setName("伦敦披萨");
        System.out.println("伦敦蓝色披萨");
    }
}
