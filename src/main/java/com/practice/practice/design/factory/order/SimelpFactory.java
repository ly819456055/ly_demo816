package com.practice.practice.design.factory.order;

import com.practice.practice.design.factory.RedPizza;
import com.practice.practice.design.factory.ApplePizza;
import com.practice.practice.design.factory.BluePizza;
import com.practice.practice.design.factory.Pizza;

/**
 * 简单工厂  披萨工厂
 */
public class SimelpFactory {
    //创建一个制造披萨的方法
    public Pizza creatPizza(String type){
        System.out.println("简单工厂");
        Pizza pizza = null;
        if (type.equals("apple")){
            pizza = new ApplePizza();
            pizza.setName(type);
        }else if (type.equals("blue")){
            pizza = new BluePizza();
            pizza.setName(type);
        }else if (type.equals("red")){
            pizza = new RedPizza();
            pizza.setName(type);
        }
        return pizza;
    }

    //静态创建制作披萨的方法
    public static Pizza creatPizza2(String type){
        System.out.println("简单工厂2");
        Pizza pizza = null;
        if (type.equals("apple")){
            pizza = new ApplePizza();
            pizza.setName(type);
        }else if (type.equals("blue")){
            pizza = new BluePizza();
            pizza.setName(type);
        }else if (type.equals("red")){
            pizza = new RedPizza();
            pizza.setName(type);
        }
        return pizza;
    }
}
