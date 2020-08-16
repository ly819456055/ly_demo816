package com.practice.practice.design.factoryMethod.factory;

/**
 * 苹果披萨
 */
public class LDApplePizza extends Pizza {

    @Override
    public void prepare() {
        setName("伦敦披萨");
        System.out.println("伦敦苹果披萨");
    }
}
