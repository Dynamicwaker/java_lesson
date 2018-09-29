package com.dynamic.threadPic.ch01;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/28.22:29
 * @description 同步锁案例
 */

public class Bank {
    private String name;
    private int money;

    public Bank(String name, int money) {
        this.money = money;
        this.name = name;
    }

    /*
     * 如果一个进程获取锁之后运行bank实例中的desposit()方法，那么其他线程无法运行
     * 这个实例中的desposit方法和withdraw方法，需要排队等待
     * 线程的互斥机制称为监视，或许锁叫做拥有监视
     * assert Thread.holdsLock(obj) 当前线程是否以获取某一对象的锁
     * synchronized静态方法和synchronized代码块使用的锁是不一样的
     *
     * 要执行wait方法，线程必须持有锁，等待的时候释放其锁
     */
    public synchronized void deposit(int m) {

        money += m;
    }
    /*
     * 等效于：
     * public void desposit(int m){
     *    synchronized(this){
     *      money += m;
     *    }
     * }
     */

    public synchronized boolean withdraw(int m) {
        if (money >= m) {
            money -= m;
            // 取款成功
            return true;
        } else {
            // 余额不足
            return false;
        }

    }

    public String getName() {
        return name;
    }

}
