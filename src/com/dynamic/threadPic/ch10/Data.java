package com.dynamic.threadPic.ch10;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/10/15.22:30
 * @description 作为共享资源角色，提供不修改内部状态的操作（read）和提供修改内部状态的操作（write）
 */

public class Data {
    private final char[] buffer;
    private final ReadWriteLock lock = new ReadWriteLock();

    public Data(int size) {
        this.buffer = new char[size];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = '*';
        }
    }

    public char[] read() throws InterruptedException {
        lock.readLock();
        try {
            // try中有return，但是在程序从方法退出之前仍然会执行finally语句块中的内容
            return doRead();
        } finally {
            lock.readUnlock();
        }
    }

    public void write(char c) throws InterruptedException {
        lock.writeLock();
        try {
            doWrite(c);
        } finally {
            lock.writeUnlock();
        }
    }

    /**
     * 数组的复制，System.arraycopy也可实现
     */
    private char[] doRead() {
        char[] newbuf = new char[buffer.length];
        for (int i = 0; i < buffer.length; i++) {
            newbuf[i] = buffer[i];
        }
        slowly();
        return newbuf;
    }

    /**
     * for循环每次执行slowly()，默认写入数据比读所需要的时间长
     *
     * @param c
     */
    private void doWrite(char c) {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = c;
            slowly();
        }
    }

    /**
     * 辅助延时功能
     */
    private void slowly() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {

        }
    }

}
