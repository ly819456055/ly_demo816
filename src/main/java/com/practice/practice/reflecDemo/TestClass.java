package com.practice.practice.reflecDemo;

import com.practice.practice.model.Doctor;
import com.practice.practice.model.Father;

import java.lang.reflect.Field;

public class TestClass {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchFieldException {
        Father father = new Father();
        Class cls = father.getClass();
        Field f = cls.getDeclaredField("sex");
        f.setAccessible(true);
        System.out.println(f.get(null));
        f.set(null,"我是人妖");
        father.getSex();

//        System.out.println(name.getType());
//        System.out.println(name.getName());
//        System.out.println(name.getModifiers());
//        System.out.println(sex.getName());
//        System.out.println(sex.getType());
//        System.out.println(sex.getModifiers());
//        createInstance();
    }

    private static void createInstance() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class c;
        if (true){
            c = Class.forName("com.practice.practice.model.Father");
//            c = Class.forName("com.practice.practice.model.Doctor");
        }else {
            c = Class.forName("com.practice.practice.model.Father");
        }
        System.out.println("name："+c.getName());
        System.out.println("simple name:" + c.getSimpleName());
        System.out.println("package name:" + c.getPackage().getName());
        System.out.println("isInterface:" + c.isInterface());
        Father doctor = (Father) c.newInstance();
        doctor.playGame();
    }
}
