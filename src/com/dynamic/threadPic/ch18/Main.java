package com.dynamic.threadPic.ch18;

import java.util.Map;
import java.util.Set;

/**
 * @author xinghuajian
 * @description
 * @date 2019/10/23 10:00
 */
public class Main {
    public static void main(String[] args) {
        Master master = new Master(new PlusWorker(), 5);
        for (int i = 0; i <= 100; i++) {
            master.submit(i);
        }

        master.execute();

        int result = 0;
        Map<String, Object> resultMap = master.getResultMap();
        while (resultMap.size() > 0 || !master.isComplete()) {
            Set<String> keys = resultMap.keySet();
            String key = null;

            for (String keyTemp : keys) {
                key = keyTemp;
                break;
            }
            Integer i = null;
            if (key != null) {
                i = (Integer) resultMap.get(key);
            }
            if (i != null) {
                result += i;
            }

            if (key != null) {
                resultMap.remove(key);
            }
        }
    }
}
