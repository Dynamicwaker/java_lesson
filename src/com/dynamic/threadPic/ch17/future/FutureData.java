package com.dynamic.threadPic.ch17.future;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/11/24.16:51
 * @description future的核心
 */

public class FutureData implements Data {
    /**
     * FutrueData是RealData的包装
     */
    protected RealData realData = null;
    protected boolean isReady = false;

    public synchronized void setRealData(RealData realData) {
        if (isReady) {
            return;
        }
        this.realData = realData;
        isReady = true;
        // realData已经被赋值，通知getResult()
        notifyAll();
    }

    @Override
    public synchronized String getResult() {
        // 未完成则一直等待
        while (!isReady) {
            try {
                // 一直等待，直到realData被复制被notifyAll()唤醒
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realData.result;

    }
}
