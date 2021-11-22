package com.dynamic.threadPic.ch18;


import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author xinghuajian
 * @description 用于任务的分配和最终结果的生成
 * @date 2019/10/23 09:52
 */
public class Master {
    /**
     * 任务队列
     */
    protected Queue<Object> workQueue = new ConcurrentLinkedDeque<>();
    /**
     * Worker进程集合
     */
    protected Map<String, Thread> threadMap = new HashMap<>();
    /**
     * 子任务处理结果集合
     */
    protected Map<String, Object> resultMap = new ConcurrentHashMap<>();

    /**
     * 判断所有的子任务是否都结束了
     *
     * @return
     */
    public boolean isComplete() {
        for (Map.Entry<String, Thread> entry : threadMap.entrySet()) {
            if (entry.getValue().getState() != Thread.State.TERMINATED) {
                return false;
            }
        }
        return true;
    }

    /**
     * Master构造方法，需要一个work进程和一个WOrker进程数量
     * @param worker
     * @param countWorker
     */
    public Master(Worker worker, int countWorker) {
        worker.setWorkQueue(workQueue);
        worker.setResultMap(resultMap);
        for (int i = 0; i < countWorker; i++) {
            threadMap.put(Integer.toString(i), new Thread(worker, Integer.toString(i)));
        }
    }

    /**
     * 提交任务
     * @param job
     */
    public void submit(Object job) {
        workQueue.add(job);
    }

    /**
     * 返回结果集
     * @return
     */
    public Map<String, Object> getResultMap() {
        return resultMap;
    }

    /**
     * 开始运行所有的worker进程，进行处理
     */
    public void execute() {
        for (Map.Entry<String, Thread> entry : threadMap.entrySet()) {
            entry.getValue().start();
        }
    }

}
