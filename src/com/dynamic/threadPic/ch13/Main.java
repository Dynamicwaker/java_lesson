package com.dynamic.threadPic.ch13;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-18
 * @description Future模式，与其一直等待，不如先拿到一张明确的“提货单”，等到真实数据操作结束，再取数据
 * 如果结果出来了，则直接领取；如果运行结果还没有出来，那么需要等待结果出来
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Main BEGIN");
        Host host = new Host();
        Data data1 = host.request(10,'A');
        Data data2 = host.request(20,'B');
        Data data3 = host.request(30,'C');
        System.out.println("Main otherJob BEGIN");
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){

        }
        System.out.println("Main otherJob END");

        System.out.println("data1 = " + data1.getContent());
        System.out.println("data2 = " + data2.getContent());
        System.out.println("data3 = " + data3.getContent());

        System.out.println("Main END");
    }
}
