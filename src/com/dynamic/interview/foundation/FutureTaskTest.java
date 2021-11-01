package com.dynamic.interview.foundation;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author:xinghj0308@gmail.com
 * @create:2020/9/21
 * @description:
 */
public class FutureTaskTest {
    public static void main(String[] args) {
        FutureTask<Integer> task = new FutureTask<>(() ->{
            System.out.println("hello");
            return 100;
        });

        new Thread(task, "task").start();
        try {
            Integer result = task.get();
            System.out.println("result is " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
