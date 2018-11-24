package com.dynamic.threadPic.ch17.jdkFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/11/24.17:30
 * @description jdk中future模式的实现
 */

public class FutureMain {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 构造FutureTask
        FutureTask<String> futureTask = new FutureTask<String>(new RealData("a"));
        // 构造线程池
        ExecutorService executor = Executors.newFixedThreadPool(1);
        // 执行FutureTask，在这里开启线程进行RealData的call()执行
        executor.submit(futureTask);
        System.out.println("请求完毕！");
        try {
            // 模拟其他业务逻辑的处理操作
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        // 获取call()方法返回值，即真实数据，如果call()方法没有执行完成，则依然会等待
        System.out.println("数据=" + futureTask.get());
    }
}
