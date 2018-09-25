package com.dynamic.interview.proxy.demoone;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-09-25
 * @description 委托类
 */
public class RealSubject implements Subject {
    @Override
    public void doSomething(){
        System.out.println("call doSomething() ");
    }
}
