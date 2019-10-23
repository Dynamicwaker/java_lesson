package com.dynamic.threadPic.ch17.future;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/11/24.16:47
 * @description 数据接口，有两个重要实现，realData和futureData，后者相当于前者的代理
 */

public interface Data {
    /**
     * 获取数据
     * @return
     */
    String getResult();
}
