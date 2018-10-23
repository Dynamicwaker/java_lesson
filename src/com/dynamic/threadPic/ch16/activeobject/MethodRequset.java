package com.dynamic.threadPic.ch16.activeobject;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-22
 * @description 抽象化的请求 具体实现是MakeStringRequest和DIsplayStringRequest
 */
public abstract class MethodRequset<T> {
    protected final Servant servant;
    protected final FutureResult<T> future;

    protected MethodRequset(Servant servant, FutureResult<T> future) {
        this.servant = servant;
        this.future = future;
    }

    public abstract void execute();

}
