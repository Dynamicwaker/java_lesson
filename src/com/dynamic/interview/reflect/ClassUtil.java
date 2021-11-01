package com.dynamic.interview.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/23.20:32
 * @description
 */

public class ClassUtil {
    /**
     * 打印类的信息，包括类的成员函数
     *
     * @param object
     * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
     */
    public static void printClassMessage(Object object) {
        // 要获取类的类类型
        Class c = object.getClass();//传递的是哪个子类的对象，c就是该子类的类类型
        // 获取类的名称
        System.out.println("类的名称是：" + c.getName());
        // Method类，方法对象
        // 一个成员方法就是一个Method对象
        // getMethods()方法获取的是所有public的函数，包括从父类继承而来的
        // getDeclaredMethods()获取的是该类自己生命的所有方法，不问访问权限
        Method[] methods = c.getMethods();//c.getDeclaredMethods()
        for (int i = 0; i < methods.length; i++) {
            // 得到方法的返回值类型的类类型
            Class returnType = methods[i].getReturnType();
            System.out.print(returnType.getName() + " ");
            // 得到方法名的名称
            System.out.print(methods[i].getName() + "(");
            Class[] paramTypes = methods[i].getParameterTypes();
            for (Class clazz : paramTypes) {
                System.out.print(clazz.getName() + " ");
            }
            System.out.println(")");
        }

    }

    /**
     * 打印类的成员变量
     *
     * @param object
     * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
     */
    public static void printFieldMessage(Object object) {
        Class c = object.getClass();
        /**
         * 成员变量也是对象
         * java.lang.reflect.Field
         * Field类封装了关于成员变量的操作
         * getFields()方法获取的是所有public的成员变量的信息,不能获取私有的
         * getDeclaredFields获取的所有该类自己生命的成员变量的信息
         */
        Field[] fs = c.getDeclaredFields();
        for (Field field : fs) {
            // 得到成员变量的类型的类类型
            Class fieldType = field.getType();
            String typeName = fieldType.getName();
            // 获取成员变量的名称的名称
            String fieldName = field.getName();
            System.out.println(typeName + " " + fieldName);
        }
    }

    /**
     * 打印构造函数
     *
     * @param
     * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
     */
    public static void printConstructorMessage(Object object) {
        Class c = object.getClass();
        // Constructor[] cs = c.getConstructors(); 获取所有的public的构造函数
        Constructor[] cs = c.getDeclaredConstructors(); // 获取所有的构造函数
        for (Constructor constructor : cs) {
            System.out.print(constructor.getName() + "(");
            Class[] paramType = constructor.getParameterTypes();
            for (Class class1 : paramType) {
                System.out.print(class1.getName() + ",");
            }
            System.out.println(")");
        }
    }
}
