package com.dynamic.interview.foundation;

import java.sql.SQLException;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/11/27.22:31
 * @description 父类
 */

public class Father {

    protected Number doSomething(int a, Integer b, Object c) throws SQLException {
        System.out.println("Father's doing something");
        return new Integer(7);
    }
}
