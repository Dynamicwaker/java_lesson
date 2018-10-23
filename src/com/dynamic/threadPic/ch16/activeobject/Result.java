package com.dynamic.threadPic.ch16.activeobject;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-22
 * @description 相当于Future模式中的VirtualData对象
 */
public abstract class Result<T> {

    public abstract T getResultValue();
}
