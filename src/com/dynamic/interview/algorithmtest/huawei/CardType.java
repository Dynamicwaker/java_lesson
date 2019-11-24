package com.dynamic.interview.algorithmtest.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2019/3/20.15:05
 * @description
 * 五张牌，每张牌由牌大小和花色组成，牌大小2~10、J、Q、K、A，牌花色为红桃、黑桃、梅花、方块四种花色之一。 判断牌型:
 * 牌型1，同花顺：同一花色的顺子，如红桃2红桃3红桃4红桃5红桃6。
 * 牌型2，四条：四张相同数字 + 单张，如红桃A黑桃A梅花A方块A + 黑桃K。
 * 牌型3，葫芦：三张相同数字 + 一对，如红桃5黑桃5梅花5 + 方块9梅花9。
 * 牌型4，同花：同一花色，如方块3方块7方块10方块J方块Q。
 * 牌型5，顺子：花色不一样的顺子，如红桃2黑桃3红桃4红桃5方块6。
 * 牌型6，三条：三张相同 + 两张单。
 * 牌型7，其他。
 * 说明：
 * 1）五张牌里不会出现牌大小和花色完全相同的牌。
 * 2）前面的牌型比后面的牌型大，如同花顺比四条大，依次类推
 */

public class CardType {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            int type = getCardType(list);
            System.out.println(type);
            list.clear();
        }
    }

    private static int getCardType(ArrayList<String> list) {
        int size = list.size();
        ArrayList<String> numList = new ArrayList<>();
        HashSet<String> numSet = new HashSet<>();
        ArrayList<String> colorLsit = new ArrayList<>();
        HashSet<String> colorSet = new HashSet<>();
        for (int i = 0; i < size; i++) {
            String num = list.get(i).split(" ")[0];
            String color = list.get(i).split(" ")[1];
            if (num.equals("J")) {
                numList.add("11");
                numSet.add("11");
            } else if (num.equals("Q")) {
                numList.add("12");
                numSet.add("12");
            } else if (num.equals("K")) {
                numList.add("13");
                numSet.add("13");
            } else if (num.equals("A")) {
                numList.add("14");
                numSet.add("14");
            } else {
                numList.add(num);
                numSet.add(num);
            }
            colorLsit.add(color);
            colorSet.add(color);
        }
        // 牌型。默认是其他
        int temp = 7;
        //同花顺或者同花
        if (colorSet.size() == 1) {
            Collections.sort(numList);
            for (int i = 0; i < numList.size() - 1; i++) {
                if (Integer.parseInt(numList.get(i + 1)) - 1 == Integer.parseInt(numList.get(i))) {
                    if (i == numList.size() - 2) {
                        temp = 1;
                    }
                    continue;
                } else {
                    if (temp > 4) {
                        temp = 4;
                    }
                }
            }
        }
        //四条或葫芦
        if (numSet.size() == 2) {
            Collections.sort(numList);
            if (numList.get(0) != numList.get(1) || numList.get(numList.size() - 1) != numList.get(numList.size() - 2)) {
                if (temp > 2) {
                    temp = 2;
                }
            } else {
                if (temp > 3) {
                    temp = 3;
                }
            }
        }
        //三条
        if (numSet.size() == 3) {
            if (temp > 6) {
                temp = 6;
            }
        }
        // 顺子
        if (colorSet.size() > 1) {
            Collections.sort(numList);
            for (int i = 0; i < numList.size() - 1; i++) {
                if (Integer.parseInt(numList.get(i + 1)) - 1 == Integer.parseInt(numList.get(i))) {
                    if (i == numList.size() - 2) {
                        temp = 5;
                    }
                    continue;
                } else {
                    break;
                }

            }
        }
        return temp;
    }

}
