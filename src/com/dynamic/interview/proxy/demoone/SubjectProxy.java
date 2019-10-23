package com.dynamic.interview.proxy.demoone;


/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-09-25
 * @description 静态代理类
 */
public class SubjectProxy implements Subject {

    Subject subimpl = new RealSubject();

    @Override
    public void doSomething() {
        subimpl.doSomething();
    }
}
