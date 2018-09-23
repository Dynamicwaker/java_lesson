package com.dynamic.interview.reflect;

import java.lang.reflect.Method;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/23.22:41
 * @description
 */

public class MethodDemo1 {
    public static void main(String[] args) {
        A a1 = new A();
        Class c = a1.getClass();
        try {
            // 传参是可变的，可以是数组，也可以一个一个传
            Method method = c.getMethod("print", new Class[]{int.class, int.class});
            //Method method1 = c.getMethod("print", int.class, int.class);

            // 方法的反射方式,通过方法对象进行调用，和a1.print(10,20)效果一样
            // 方法如果没有返回值则返回null，有返回值则返回具体的返回值
            Object object = method.invoke(a1, new Object[]{10, 20});
            System.out.println("-------------------------------------");
            Method method1 = c.getMethod("print", new Class[]{String.class, String.class});
            Object object1 = method1.invoke(a1, new Object[]{"a", "b"});
            System.out.println("-------------------------------------");
            // 两种都可以
            Method method2 = c.getMethod("print", new Class[]{});
            method2.invoke(a1);

            Method method3 = c.getMethod("print");
            method3.invoke(a1, new Object[]{});
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

