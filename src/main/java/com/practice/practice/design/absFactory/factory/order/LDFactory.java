package com.practice.practice.design.absFactory.factory.order;

import com.practice.practice.design.absFactory.factory.LDApplePizza;
import com.practice.practice.design.absFactory.factory.LDBluePizza;
import com.practice.practice.design.absFactory.factory.Pizza;

public class LDFactory implements AbsFactory{
    @Override
    public Pizza createFactory(String orderType) {
        Pizza pizza = null;
        System.out.println("抽象工厂模式");
        if (orderType.equals("apple")){
            pizza = new LDApplePizza();
        }else if (orderType.equals("blue")){
            pizza = new LDBluePizza();
        }
        return pizza;
    }
}
