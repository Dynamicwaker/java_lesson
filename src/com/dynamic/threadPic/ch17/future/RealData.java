package com.dynamic.threadPic.ch17.future;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/11/24.16:52
 * @description 最终真实的数据
 */

public class RealData implements Data {

    protected final String result;

    public RealData(String data) {
        // realData的构造可能很慢，需要用户等待很久，这里使用sleep模拟
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(data).append("/");
            try {
                // 这里使用sleep，代替一个很慢的操作过程
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        }
        result = sb.toString();
    }

    @Override
    public String getResult() {
        return result;
    }
}
