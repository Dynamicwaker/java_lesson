package com.dynamic.threadPic.ch16;

import com.dynamic.threadPic.ch16.activeobject.ActiveObject;
import com.dynamic.threadPic.ch16.activeobject.Result;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-22
 * @description 调用主动对象的makeString方法生成字符串的线程
 */
public class MakerClientThread extends Thread {
    private final ActiveObject activeObject;
    private final char fillchar;

    public MakerClientThread(String name, ActiveObject activeObject) {
        super(name);
        this.activeObject = activeObject;
        this.fillchar = name.charAt(0);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; true; i++) {
                // 有返回值的调用，调用之后立即返回，返回值是Result模式，Future模式，getResultValue（）可以获得异步之后的值
                Result<String> result = activeObject.makeString(i, fillchar);
                Thread.sleep(10);
                String value = result.getResultValue();
                System.out.println(Thread.currentThread().getName() + ": value = " + value);
            }
        } catch (InterruptedException e) {

        }
    }
}
