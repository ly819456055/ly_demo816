package com.practice.practice.design.factoryMethod.factory.order;

import com.practice.practice.design.factoryMethod.factory.BJApplePizza;
import com.practice.practice.design.factoryMethod.factory.BJBluePizza;
import com.practice.practice.design.factoryMethod.factory.Pizza;

public class BJOrderPizza extends OrderPizza{
    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("apple")){
            pizza = new BJApplePizza();
        }else if (type.equals("blue")){
            pizza = new BJBluePizza();
        }
        return pizza;
    }
}
