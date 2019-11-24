package com.dynamic.interview.algorithmtest.huawei;

import java.util.*;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2019/3/20.11:12
 * @description 输入第一行为一个正整数n(1≤n≤1000), 下面n行为n个字符串(字符串长度≤100), 字符串中只含有大小写字母。
 */

public class SortString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 取第一行的正整数，判断元素的个数
        int n = scanner.nextInt();
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            strings.add(scanner.next());
        }
        Collections.sort(strings);
        Iterator it = strings.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
