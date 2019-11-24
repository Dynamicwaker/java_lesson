package com.dynamic.interview.algorithmtest.huawei;

import java.util.Scanner;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2019/3/20.10:14
 * @description 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”,所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 */

public class ReverseSentence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            System.out.println(new ReverseSentence().reverse(str));
        }
    }

    public String reverse(String sentence) {
        String[] arr = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=arr.length-1; i>=0; i--) {
            sb.append(arr[i] + " ");
        }
        return sb.toString().trim();
    }
}
