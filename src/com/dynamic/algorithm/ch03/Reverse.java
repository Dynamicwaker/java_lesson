package com.dynamic.algorithm.ch03;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/9/8.17:37
 * @description 单词逆转
 */

public class Reverse {

    private String input;

    public Reverse(String input){
        this.input = input;
    }

    public String doReverse(){
        MycharStack mycharStack = new MycharStack(input.length());
        for(int i = 0;i<input.length();i++){
            char ch = input.charAt(i);
            mycharStack.push(ch);
        }
        String output = "";
        while(!mycharStack.isEmpty()){
            char ch = mycharStack.pop();
            output += ch;
        }
        return output;
    }

}
