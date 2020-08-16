package com.practice.practice.design.factoryMethod.factory.order;

import com.practice.practice.design.factoryMethod.factory.Pizza;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public abstract class OrderPizza {
    abstract Pizza createPizza(String type);

    public OrderPizza() {
        Pizza pizza = null;
        String orderType = "";
        do {
            orderType = getType();
            pizza = createPizza(orderType);
            if (pizza!=null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.pack();
            }
        } while (true);

    }

    private String getType() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入披萨类型：");
            String str = strin.readLine();
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
