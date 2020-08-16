//package com.practice.practice.design.factory.order;
//
//import com.practice.practice.design.factory.Pizza;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
///**
// * 订购披萨
// */
//public class OrderPizza {
//    //创建一个工厂变量
//    SimelpFactory simelpFactory;
//    //创建披萨对象
//    Pizza pizza = null;
//
//    //通过构造方法依赖工厂
//
//    public OrderPizza(SimelpFactory simelpFactory) {
//       setFactory(simelpFactory);
//    }
//
//    private void setFactory(SimelpFactory simelpFactory) {
//        String orderType = "";
//        this.simelpFactory = simelpFactory;
//        do{
//            //根据控制台输出获取披萨类型
//            orderType = getType();
//            //根据控制台输入的披萨名称去工厂生产对应的披萨
//            pizza = simelpFactory.creatPizza(orderType);
//            if (pizza != null){
//                pizza.prepare();
//                pizza.bake();
//                pizza.cut();
//                pizza.pack();
//            }else {
//                System.out.println("没有该类型的披萨");
//                break;
//            }
//        }while (true);
//    }
//
//    private String getType() {
//        try {
//            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
//            System.out.println("请输入订购的披萨类型：");
//            String str = strin.readLine();
//            return str;
//        }catch (Exception e){
//            e.printStackTrace();
//            return "";
//        }
//    }
//}
