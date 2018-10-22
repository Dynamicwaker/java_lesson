package com.dynamic.threadPic.ch15.noPattern;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-22
 * @description
 */
public class Log {
    private static PrintWriter writer = null;

    static {
        try {
            writer = new PrintWriter(new FileWriter("log.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void println(String s) {
        writer.println(s);
    }

    public static void close() {
        writer.println("=== END OF LOG ===");
        writer.close();
    }
}
