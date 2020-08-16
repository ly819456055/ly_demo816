package com.practice.practice.design.absFactory.factory.order;

import com.practice.practice.design.absFactory.factory.Pizza;
//抽象共产层  (接口)
public interface AbsFactory {
    Pizza createFactory(String orderType);
}
