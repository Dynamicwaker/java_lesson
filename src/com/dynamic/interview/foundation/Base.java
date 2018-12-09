package com.dynamic.interview.foundation;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-12-09
 * @description 父类
 */
public class Base {
    private int i = 2;

    public Base() {
        /**
         * 在子类调父类的构造器时，核心是，this指代的是子类对象
         * 但是编译的时候Base对象，实际指向的却是子类Derived对象
         * 当变量的编译时类型和运行时不同时（多态），通过改变量访问它引用对象的实例变量，该实例变量的值应该由声明该变量的类型决定
         * 但通过该变量调用引用的对象的实例方法时，该方法行为将由它实际所引用的对象来决定
         * 即、访问this.i的时候，访问base对应i是，值是2，但是执行this.display则表现的是Derived对象的行为，也就是Derived对象的i的值，就是0
         */
        System.out.println(this.i);
        System.out.println(this.getClass());
        this.display();
    }

    public void display() {
        System.out.println(i);
    }
}
