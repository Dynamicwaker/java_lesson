package com.dynamic.threadPic.ch13;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-18
 * @description 向请求发送FutureData的实例的类
 */
public class Host {
    public Data request(final int count, final char c) {
        System.out.println(" request(" + count + ", " + c + ") BEGIN");
        final FutureData futureData = new FutureData();
        new Thread() {
            @Override
            public void run() {
                RealData realData = new RealData(count, c);
                futureData.setRealData(realData);
            }
        }.start();
        System.out.println(" request(" + count + ", " + c + ") END");
        return futureData;
    }
}
