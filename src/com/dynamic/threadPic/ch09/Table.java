package com.dynamic.threadPic.ch09;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-14
 * @description 扮演模式中的桥梁角色，channel角色，消除生产和消费之间处理速度的差异
 */
public class Table {
    private final String[] buffer;
    /**
     *下次put的位置
      */
    private int tail;
    /**
     *下次take的位置
     */
    private int head;
    /**
     * buffer中的蛋糕个数
     */
    private int count;

    public Table(int count) {
        this.buffer = new String[count];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    /**
     * throws InterruptedException 可以理解为可以取消
      */
    public synchronized void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " puts " + cake);
        // !count >= buffer.length 守护条件
        while (count >= buffer.length) {
            wait();
        }
        buffer[tail] = cake;
        tail = (tail + 1) % buffer.length;
        count++;
        notifyAll();
    }

    public synchronized String take() throws InterruptedException {
        // 守护条件 count > 0
        while (count <= 0) {
            wait();
        }
        String cake = buffer[head];
        // 更新下次取的位置和个数（每次拿走一个 -1）
        head = (head + 1) % buffer.length;
        count--;
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " takes " + cake);
        return cake;
    }
}
