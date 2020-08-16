package com.practice.practice.design.factoryMethod.factory.order;

import com.practice.practice.design.factoryMethod.factory.*;

public class LDOrderPizza extends OrderPizza{
    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("apple")){
            pizza = new LDApplePizza();
        }else if (type.equals("blue")){
            pizza = new LDBluePizza();
        }
        return pizza;
    }
}
