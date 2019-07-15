package com.dynamic.threadPic.ch09;

import java.util.Random;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-14
 * @description 生产者角色
 */
public class MakerThread extends Thread {
    private final Random random;
    private final Table table;
    private static int id = 0;

    public MakerThread(String name, Table table, long seed) {
        super(name);
        this.random = new Random(seed);
        this.table = table;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(random.nextInt(1000));
                String cake = "[ Cake No." + nextId() + " by " + getName() + " ]";
                table.put(cake);
            }
        } catch (InterruptedException e) {
        }
    }

    private static synchronized int nextId() {
        return id++;
    }
}
