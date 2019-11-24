package com.dynamic.interview.pattern.factory;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2019/3/23.12:44
 * @description 创建实现该接口的具体图形类
 */

public class Circle  implements Shape{
    public Circle() {
        System.out.println("Circle");
    }
    @Override
    public void draw() {
        System.out.println("Draw Circle");
    }
}
