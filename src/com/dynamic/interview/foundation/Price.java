package com.dynamic.interview.foundation;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-12-09
 * @description 类变量初始化另一个demo
 */
public class Price {
    final static Price INSTANCE = new Price(2.8);

    static double initPrice = 20;
    double currentPrice;

    public Price(double discount) {
        currentPrice = initPrice - discount;
    }

    public static void main(String[] args) {
        /**
         * 这边有一个细节定义类变量为其分配内存空间，此时，还没有赋值，
         * INSTANCE和initPrice还是默认值，分别是NULL和0.0，然后再执行赋值的逻辑
         * 为INSTANCE赋值要创建Price，要调Price的构造方法，此时会currentPrice被初始化，但是这时候的initPrice还只是初始默认值0.0
         */
        System.out.println(Price.INSTANCE.currentPrice);
        Price price = new Price(2.8);
        System.out.println(price.currentPrice);
    }
}
