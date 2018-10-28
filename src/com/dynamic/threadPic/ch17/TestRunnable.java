package com.dynamic.threadPic.ch17;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/10/28.17:34
 * @description 在Java中有两类线程：User Thread(用户线程)、Daemon Thread(守护线程)
 */

public class TestRunnable implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);//守护线程阻塞1秒后运行
            File f = new File("daemon.txt");
            FileOutputStream os = new FileOutputStream(f, true);
            os.write("daemon".getBytes());
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }
}
