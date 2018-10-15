package com.dynamic.threadPic.ch10;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/10/15.22:31
 * @description 读写交叉，除了读与读时没有冲突，其他都有冲突
 */

public class ReadWriteLock {
    /**
     * 实际正在读取中的线程个数
     */
    private int readingReaders = 0;
    /**
     * 正在等待写入中的线程个数
     */
    private int waitingWriters = 0;
    /**
     * 实际正在写入中的线程个数
     */
    private int writingWriters = 0;
    /**
     * 若先写入，则为true
     */
    private boolean perferWriter = true;

    public synchronized void readLock() throws InterruptedException {
        while (writingWriters > 0 || (perferWriter && waitingWriters > 0)) {
            wait();
        }
        // 实际正在读取的线程个数增加1
        readingReaders++;
    }

    public synchronized void readUnlock() {
        // 实际正在读取的线程的个数减1
        readingReaders--;
        perferWriter = true;
        notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        // 正在等待写入的线程增加1
        waitingWriters++;
        try {
            while (readingReaders > 0 || writingWriters > 0) {
                wait();
            }
        } finally {
            // 正在等待写入的线程个数减少1
            waitingWriters--;
        }
        // 实际正在写入的线程个数增加1
        writingWriters++;
    }

    public synchronized void writeUnlock(){
        // 实际正在写入的线程个数减少1
        writingWriters--;
        perferWriter = false;
        notifyAll();
    }
}
