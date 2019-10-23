package com.dynamic.interview.proxy.demotwo;

/**
 * @author xinghuajian
 * @description
 * @date 2019/10/21 13:55
 */
public class Transaction {

    public void beginTransaction() {
        System.out.println("begin transaction");
    }

    public void commint() {
        System.out.println("transaction commint");
    }


}
