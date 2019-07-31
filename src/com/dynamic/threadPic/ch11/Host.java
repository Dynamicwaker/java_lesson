package com.dynamic.threadPic.ch11;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/10/16.20:43
 * @description 由新创建的线程去处理请求,
 * 1. 能提高响应性，缩短延迟时间
 * 2. 适用于操作顺序没有要求
 * 3. 适用于不需要返回值
 */

public class Host {
    private final Helper helper = new Helper();

    /**
     * request方法并不会等待handle方法执行结束，而是立即返回，创建了新的线程
     * @param count
     * @param c
     */
    public void request(final int count, final char c) {
        System.out.println(" request(" + count + ", " + c + ") BEGIN");
        // 匿名内部类用到的出参数需要声明成final
        new Thread(
                new Runnable() {
                    public void run() {
                        helper.handle(count, c);
                    }
                }
        ).start();
        System.out.println(" request(" + count + ", " + c + ") END");
    }
}
