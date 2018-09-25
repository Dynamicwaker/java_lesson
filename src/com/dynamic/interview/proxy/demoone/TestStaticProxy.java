package com.dynamic.interview.proxy.demoone;


/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-09-25
 * @description 测试静态代理
 */
public class TestStaticProxy {
    public static void main(String[] args) {
        Subject sub = new SubjectProxy();
        sub.doSomething();
    }
}
