package com.dynamic.threadPic.ch15.pattern;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-22
 * @description 线程特有对象的代理人
 */
public class Log {
    /**
     * 线程特有对象的集合
    */
    private static final ThreadLocal<TSLog> tsLogCollection = new ThreadLocal<TSLog>();
    // 实现都委托给getTSLog()


    public static void println(String s){
        getTSLog().println(s);
    }
    public static void close(){
        getTSLog().close();
    }
    // 获取线程特有的日志
    private static TSLog getTSLog(){
        TSLog tsLog = tsLogCollection.get();
        // 如果该线程是第一次调用本方法，就新生成并注册一个日志
        if (tsLog == null){
            tsLog = new TSLog(Thread.currentThread().getName()+"-log.txt");
            tsLogCollection.set(tsLog);
        }
        return tsLog;
    }
}
