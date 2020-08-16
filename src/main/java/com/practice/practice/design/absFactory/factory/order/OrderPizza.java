package com.practice.practice.design.absFactory.factory.order;

import com.practice.practice.design.absFactory.factory.Pizza;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OrderPizza {

    AbsFactory factory;

    public OrderPizza(AbsFactory factory) {
        setFactory(factory);
    }

    private void setFactory(AbsFactory factory) {
        String orderType = "";
        this.factory = factory;
        Pizza pizza = null;
        //获取输入类型
        do {
            orderType = getType();
            pizza = factory.createFactory(orderType);
            if (pizza!=null){
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.pack();
            }else {
                System.out.println("没有该类型");
                break;
            }
        } while (true);
    }

    private String getType() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入类型：");
            String str = strin.readLine();
            return str;
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }

    }

}
