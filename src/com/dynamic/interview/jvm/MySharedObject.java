package com.dynamic.interview.jvm;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-24
 * @description MySharedObject类也包含两个成员变量，这些成员变量随着这个对象存放在堆上，这两个成员变量指向另外两个Integer对象
 * methodTwo()创建一个名为localVariable的本地变量。这个成员变量是一个指向一个Integer对象的对象引用。
 * 这个方法设置localVariable1引用指向一个新的Integer实例。
 * MySharedObject类中的两个long类型的成员变量是原始类型的。因为，这些变量是成员变量，所以它们任然随着该对象存放在堆上
 */
public class MySharedObject {
    //static variable pointing to instance of MySharedObject

    public static final MySharedObject sharedInstance =
            new MySharedObject();


    //member variables pointing to two objects on the heap
    /**
     * Integer对象（object2，object4）实例化将会被存储堆上
    */
    public Integer object2 = new Integer(22);
    public Integer object4 = new Integer(44);

    public long member1 = 12345;
    public long member2 = 67890;
}
