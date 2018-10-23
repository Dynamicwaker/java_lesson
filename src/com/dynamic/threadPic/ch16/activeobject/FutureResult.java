package com.dynamic.threadPic.ch16.activeobject;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-22
 * @description 相当于Future模式的Future角色，用于操作返回值
 */
public class FutureResult<T> extends Result<T> {
    private Result<T> result;
    private boolean ready = false;

    public synchronized void setResult(Result<T> result){
        this.result = result;
        this.ready =  true;
        notifyAll();
    }

    @Override
    public synchronized T getResultValue(){
        while (!ready){
            try{
                wait();
            }catch (InterruptedException e){

            }
        }
        return result.getResultValue();
    }
}
