package com.dynamic.interview.foundation;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-11-30
 * @description finally无效情况
 */
public class FinallyNotWork {
    public static void main(String[] args) {
        /**
         * finally是在return表达式之后执行，此时return的结果已经被暂存下来，
         * 待finally执行结束才会把之前暂存的数据返回，所以此处的temp值是1001
         * finally没有执行的情况：1、没有进入try方法 2、进入try方法，但是出现死循环或者死锁 3、try中有System.exit()
        */
        System.out.println("temp的值是：" + notWork());
    }

    public static int notWork() {
        int temp = 1000;
        try {
            throw new Exception();
        } catch (Exception e) {
            return ++temp;
        } finally {
            temp = 99999;
        }
    }
}
