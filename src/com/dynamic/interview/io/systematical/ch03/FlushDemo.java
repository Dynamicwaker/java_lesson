package com.dynamic.interview.io.systematical.ch03;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author xinghuajian
 * @description flush下达一条命令给缓冲区，让它将所储存的数据全部清空，即发送给下一级。
 * @date 2019/7/26 13:42
 */
public class FlushDemo {

    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1", 80);
        // 模拟浏览器，给tomcat服务端发送符合http协议的请求消息  这里的ture表示流会自动刷新，在后面可以不用使用flush()方法
        PrintWriter out = new PrintWriter(s.getOutputStream());
        out.println("GET /myweb/1.html HTTP/1.1");
        out.println("Host: 127.0.0.1:80");
        out.println("Connection: close");
        out.println("Accept: */*");
        out.println("Accept-Language: zh-CN");
        out.println("User-Agent: Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.1; WOW64; Trident/5.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; InfoPath.2; SE 2.X MetaSr 1.0)");
        out.println("Accept-Encoding: gzip, deflate");
        out.println();
        out.println();
        // 清空缓存并输出流
        out.flush();
        InputStream in = s.getInputStream();
        byte[] byteArr = new byte[1024];
        int leng;
        while ((leng = in.read(byteArr)) != -1) {
            String str = new String(byteArr, 0, leng);
            System.out.println(str);
        }
        s.close();
    }

}
