package com.dynamic.threadPic.ch13;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-18
 * @description 相当于是一个提货单
 */
public class FutureData implements Data {

    private RealData realData = null;
    // 是否已经为realData赋值的字段

    private boolean ready = false;

    public synchronized void setRealData(RealData realData) {
        // 如果已经赋值过了，则立即返回
        if (ready) {
            return;
        }
        this.realData = realData;
        this.ready = true;
        notifyAll();
    }

    @Override
    public synchronized String getContent() {
        // 如果还没有赋值，则等待
        while (!ready) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        return realData.getContent();
    }
}
