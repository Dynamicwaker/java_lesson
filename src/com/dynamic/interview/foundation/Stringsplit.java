package com.dynamic.interview.foundation;

import java.util.StringTokenizer;

/**
 * @author xinghuajian
 * @description
 * @date 2019/10/22 10:24
 */
public class Stringsplit {
    public static void main(String[] args) {
        String orgStr = null;

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < 10000; i++) {
            sb.append(i);
            sb.append(";");
        }
        orgStr = sb.toString();

        StringTokenizer st = new StringTokenizer(orgStr, ";");

        for (int i = 0; i < 10000; i++) {
            while (st.hasMoreTokens()) {
                st.nextToken();
            }
            st = new StringTokenizer(orgStr, ";");
        }

        System.out.println(orgStr);
    }
}
