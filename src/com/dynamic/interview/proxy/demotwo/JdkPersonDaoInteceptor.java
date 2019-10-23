package com.dynamic.interview.proxy.demotwo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author xinghuajian
 * @description
 * 总结：
 * 1、因为利用JDKProxy生成的代理类实现了接口，所以目标类中所有的方法在代理类中都有。
 * 2、生成的代理类的所有的方法都拦截了目标类的所有的方法。而拦截器中invoke方法的内容正好就是代理类的各个方法的组成体。
 * 3、利用JDKProxy方式必须有接口的存在。
 * 4、invoke方法中的三个参数可以访问目标类的被调用方法的API、被调用方法的参数、被调用方法的返回类型。
 * @date 2019/10/21 14:05
 */
public class JdkPersonDaoInteceptor implements InvocationHandler {

    private Object target;

    private Transaction transaction;

    public JdkPersonDaoInteceptor(Object target, Transaction transaction) {
        this.target = target;
        this.transaction = transaction;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj;

        String methodName = method.getName();


        if ("savePerson".equals(methodName) || "updatePerson".equals(methodName) || "deletePerson".equals(methodName)) {
            this.transaction.beginTransaction();
            // 调用目标类的目标方法，加上事务处理
            obj = method.invoke(this.target, args);
            this.transaction.commint();
        } else {
            obj = method.invoke(this.target, args);
        }
        return obj;

    }
}
