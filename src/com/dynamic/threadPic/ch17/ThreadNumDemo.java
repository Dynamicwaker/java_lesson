package com.dynamic.threadPic.ch17;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-27
 * @description java程序至少会启动几个线程？ 2个，一个main，一个垃圾回收
 */
public class ThreadNumDemo {
    public static void main(String[] args) {
        /*;
        6 - Monitor Ctrl-Break
        5 - Attach Listener // 添加监听
        4 - Signal Dispatcher //分发处理发送给JVM信号的线程
        3 - Finalizer //调用对象的finalize方法的线程，就是垃圾回收的线程
        2 - Reference Handler //清除reference的线程
        1 - main //主线程*/
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println(threadInfo.getThreadId() + "--" + threadInfo.getThreadName());
        }
    }
}
