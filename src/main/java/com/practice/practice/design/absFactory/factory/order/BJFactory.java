package com.practice.practice.design.absFactory.factory.order;

import com.practice.practice.design.absFactory.factory.BJApplePizza;
import com.practice.practice.design.absFactory.factory.BJBluePizza;
import com.practice.practice.design.absFactory.factory.Pizza;

public class BJFactory implements AbsFactory{
    @Override
    public Pizza createFactory(String orderType) {
        Pizza pizza = null;
        System.out.println("抽象工厂模式");
        if (orderType.equals("apple")){
            pizza = new BJApplePizza();
        }else if (orderType.equals("blue")){
            pizza = new BJBluePizza();
        }
        return pizza;
    }
}
