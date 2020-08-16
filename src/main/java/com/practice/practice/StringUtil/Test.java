package com.practice.practice.StringUtil;

import java.util.HashMap;
import java.util.HashSet;

class Cat {
    public Cat(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class Test {
    public static void main(String[] args) {
        String s1 = "string";
        String s2 = "string";
        String s3 = new String("string");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        HashSet<String> set = new HashSet<>();
        set.add("sss");
        HashMap<String,String> map = new HashMap<>();
        map.put("",""   );
//        Cat cat1 = new Cat("张三");
//        Cat cat2 = new Cat("张三");
//        System.out.println(cat1.getName().equals(cat2.getName()));
//        String s1 = new String("java");
//        String s2 = new String("java");
//        System.out.println(s1.equals(s2));
    }
}
