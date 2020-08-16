package com.practice.practice.design.factory;

/**
 * 披萨抽象类
 */
public abstract class Pizza {
    //披萨的名称
    protected String name;
    //制作披萨
    public abstract void prepare();
    //烘焙
    public void bake(){
        System.out.println(name + "baking");
    }
    //切割披萨
    public void cut(){
        System.out.println(name + "cuting");
    }
    //打包披萨
    public void pack(){
        System.out.println(name + "packing");
    }

    public void setName(String name){
        this.name = name;
    }

}
