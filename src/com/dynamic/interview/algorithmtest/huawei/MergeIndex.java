package com.dynamic.interview.algorithmtest.huawei;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2019-02-19
 * @description 描述：数据表记录包含表索引和数值，请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 */
public class MergeIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>(16);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                int key = scanner.nextInt();
                int value = scanner.nextInt();
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + value);
                } else {
                    map.put(key, value);
                }
            }
            Object[] key_arr = map.keySet().toArray();
            Arrays.sort(key_arr);
            for (Object keyTemp : key_arr) {
                System.out.print(keyTemp);
                System.out.print(" ");
                System.out.println(map.get(keyTemp));
            }
        }
    }
}
