package com.dynamic.interview.pattern.factory;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2019/3/23.12:48
 * @description  使用反射机制改善简单工厂
 * 工厂模式：举两个比较常见的例子：(我暂时可以准确想到的，当然还有很多很多):
 * (1)Spring中通过getBean(“xxx”)获取Bean；
 * (2) Java消息服务JMS中(下面以消息队列ActiveMQ为例子)
 */

public class ShapeFactory2 {
    public static Object getClass(Class<? extends Shape> clazz) {
        Object obj = null;
        try {
            obj = Class.forName(clazz.getName()).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return obj;
    }

    /**
     * Circle circle = (Circle) ShapeFactory2.getClass(factory_pattern.Circle.class);
     * circle.draw();
     *  可以通过反射来调用
     */

}
