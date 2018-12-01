package com.dynamic.interview.foundation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-12-01
 * @description
 */
public class ListNoGeneric {
    public static void main(String[] args) {
        List a1 = new ArrayList();
        a1.add(new Object());
        a1.add(new Integer(1));
        a1.add(new String("Hello a1"));

        List<Object> a2 = a1;
        a2.add(new Object());
        a2.add(new Integer(222));
        a2.add(new String("Hello a2"));

        List<Integer> a3 = a1;
        a3.add(new Integer(222));
        /**
         *  a3.add(new Object());
         *  a3.add(new String("Hello a3"));
         *  会编译报错，不允许这么增加非Integer对象
        */

        List<?> a4 = a1;
        a1.remove(0);
        a4.clear();
        /**
         * 不允许加入任何对象
         * a4.add(new Object());
        */





    }
}
