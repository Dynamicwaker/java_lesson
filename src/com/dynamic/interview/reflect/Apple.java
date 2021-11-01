package com.dynamic.interview.reflect;

/**
 * @author:xinghj0308@gmail.com
 * @create:2021/5/29
 * @description:
 */
public class Apple {

    @FruitProvider(id = 1, name = "陕西红富士集团", address = "陕西省西安市")
    private String appleProvider;

    public String getAppleProvider() {
        return appleProvider;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }
}
