package com.dynamic.interview.foundation;

import java.sql.SQLClientInfoException;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/11/27.22:31
 * @description 子类方法覆写，一大两小两同
 */

public class SubSon extends Father {
    /**
     * 一大：
     * 1.权限扩大，protected---public
     * 两小：
     * 2.返回值是父类的Number的子类
     * 3.抛出的的异常是父类抛出的异常的子类
     * 两同：
     * 4.方法名必须相同
     * 5.方法的参数必须严格一致
     * <p>
     * 6.必须加入@Override注解
     */
    @Override
    public Integer doSomething(int a, Integer b, Object c) throws SQLClientInfoException {

        if (a == 7) {
            throw new SQLClientInfoException();
        }
        return new Integer(17);
    }
}
