package com.dynamic.interview.foundation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinghuajian
 * @description substring溢出问题
 * @date 2019/10/22 09:22
 */
public class SubStrDe {


    public static void main(String[] args) {
        List<String> handler = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            // 可能会出现溢出的
            HugeStr h = new HugeStr();
            //ImprovedHugeStr h = new ImprovedHugeStr();

            handler.add(h.getSubString(1, 5));
        }
    }

    public static class HugeStr {
        private String str = new String(new char[1000000]);

        public String getSubString(int begin, int end) {
            return str.substring(begin, end);
        }
    }


    public static class ImprovedHugeStr {
        private String str = new String(new char[1000000]);

        public String getSubString(int begin, int end) {
            return new String(str.substring(begin, end));
        }
    }
}
