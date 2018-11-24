package com.dynamic.threadPic.ch17.future;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/11/24.17:11
 * @description
 */

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        // 请求完立即返回，因为得到的是FutureData而不是RealData
        Data data = client.request("name");
        System.out.println("请求完毕！");
        try {
            /**
             * 这里使用一个sleep模拟对其他业务逻辑的处理
             * 在其他业务逻辑被处理的过程中，RealData被创建赋值，从而充分利用了等待的时间
             */
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        // 获取到真实的数据realData
        System.out.println("数据=" + data.getResult());

    }
}
