package com.dynamic.threadPic.ch15.pattern;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-22
 * @description 线程特有的对象，包含着线程的特有信息
 */
public class TSLog {
    private PrintWriter writer = null;
    public TSLog(String fileName){
        try{
            writer = new PrintWriter(new FileWriter(fileName));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    // 写日志
    public void println(String s){
        writer.println(s);
    }

    // 关闭日志
    public void close(){
        writer.println("=== End of log ===");
        writer.close();
    }
}
