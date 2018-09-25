package com.dynamic.interview.proxy.demoone;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-09-25
 * @description 在使用动态代理时，我们需要定义一个位于代理类与委托类之间的中介类,这个中介类被要求实现InvocationHandler接口
 */
public class ProxyHandler implements InvocationHandler {
    // 委托类对象
    private Object target;

    //绑定委托对象，并返回代理类
    public Object bind(Object target) {
        this.target = target;
        //绑定该类实现的所有接口，取得代理类
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        //这里就可以进行所谓的AOP编程了
        //在调用具体函数方法前，执行功能处理
        result = method.invoke(target, args);
        //在调用具体函数方法后，执行功能处理
        return result;
    }

}
