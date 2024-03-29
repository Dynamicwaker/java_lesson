package com.dynamic.threadPic.ch18;

import java.util.Map;
import java.util.Queue;

/**
 * @author xinghuajian
 * @description
 * @date 2019/10/23 10:00
 */
public class Worker implements Runnable {
    /**
     * 任务队列，用于取得子任务
     */
    protected Queue<Object> workQueue;
    /**
     * 子任务处理结果集
     */
    protected Map<String, Object> resultMap;

    public void setWorkQueue(Queue<Object> workQueue) {
        this.workQueue = workQueue;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    /**
     * 子任务的处理的逻辑
     */
    public Object handle(Object input) {
        return input;
    }

    @Override
    public void run() {
        while (true) {
            // 取得任务
            Object input = workQueue.poll();

            if (input == null) {
                break;
            }
            // 处理子任务
            Object re = handle(input);
            // 将结果写入结果集
            resultMap.put(Integer.toString(input.hashCode()), re);
        }
    }
}
