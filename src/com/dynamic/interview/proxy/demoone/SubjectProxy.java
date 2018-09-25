package com.dynamic.interview.proxy.demoone;

import com.dynamic.interview.proxy.demoone.RealSubject;
import com.dynamic.interview.proxy.demoone.Subject;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-09-25
 * @description 代理类
 */
public class SubjectProxy implements Subject {

    Subject subimpl = new RealSubject();

    public void doSomething() {
        subimpl.doSomething();
    }
}
