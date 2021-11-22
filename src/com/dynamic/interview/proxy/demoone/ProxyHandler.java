package com.dynamic.interview.proxy.demoone;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-09-25
 * @description 在使用动态代理时，我们需要定义一个位于代理类与委托类之间的中介类,这个中介类被要求实现InvocationHandler接口
 * 就相当于拦截器，1、给目标类和其他类赋值 2、拦截器中的invoke()方法的内容就是代理对象方法的内容
 */
public class ProxyHandler implements InvocationHandler {
    /**
     委托类对象
      */
    private Object target;

    /**
     * 绑定委托对象，并返回代理类
     */
    public Object bind(Object target) {
        this.target = target;
        /**
         * 绑定该类实现的所有接口，取得代理类，这个可以写在任意位置
         * newProxyInstance参数列表：1、目标类的类加载器 2、目标类的所有接口 3、拦截器Handler
         */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    /**
     * 代理对象的方法内容，代理对象调用方法的时候，就进入了拦截器中invoke()方法，
     * 这个例子中的就是在调用subject的doSomething()方法时，调用了invoke()方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
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
