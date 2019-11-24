package com.dynamic.interview.algorithmtest.huawei;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2019/3/20.14:00
 * @description 输入描述:一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。输出描述:将所有的记录统计并将结果输出，格式：文件名 代码行数 数目，一个空格隔开，如：
 */

public class SplitPath {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 可以保持顺序
        Map<String, Integer> map = new LinkedHashMap<>();
        while (sc.hasNext()) {
            String str = sc.next();
            int linenum = sc.nextInt();
            //根据\切割
            String[] arr = str.split("\\\\");
            String s = arr[arr.length - 1];
            if (s.length() > 16) {
                //截取
                s = s.substring(s.length() - 16);
            }
            String key = s + " " + linenum;
            // 计数
            int value = 1;
            if (map.containsKey(key))
                map.put(key, map.get(key) + 1);
            else {
                map.put(key, value);
            }
        }
        int count = 0;
        for (String string : map.keySet()) {
            count++;
            //输出最后八个记录，只有当最后8个
            if (count > (map.keySet().size() - 8)) {
                System.out.println(string + " " + map.get(string));
            }
        }

    }
}

