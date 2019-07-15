package com.dynamic.threadPic.ch16.activeobject;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-22
 * @description Future模式中的RealData角色
 */
public class RealResult<T> extends Result<T> {
    private final T resultValue;

    public RealResult(T resultValue) {
        this.resultValue = resultValue;
    }

    @Override
    public T getResultValue() {
        return resultValue;
    }
}
