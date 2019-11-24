package com.dynamic.interview.algorithmtest.huawei;

import java.util.Scanner;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2019/3/20.11:56
 * @description 输入的第 1 行，为两个正整数，用一个空格隔开：N m（其中 N （ <32000 ）表示总钱数， m （ <60 ）为希望购买物品的个数。）
 * 从第 2 行到第 m+1 行，第 j 行给出了编号为 j-1 的物品的基本数据，每行有 3 个非负整数 v p q
 * （其中 v 表示该物品的价格（ v<10000 ）， p 表示该物品的重要度（ 1 ~ 5 ）， q 表示该物品是主件还是附件。如果 q=0 ，表示该物品为主件，如果 q>0 ，表示该物品为附件， q 是所属主件的编号）
 */

public class ShoppingList {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int n = input.nextInt(); // 总钱数
            int m = input.nextInt(); // 商品个数
            int[] p = new int[m];
            int[] v = new int[m];
            int[] q = new int[m];
            for (int i = 0; i < m; i++) {
                p[i] = input.nextInt();        // 价格
                v[i] = input.nextInt() * p[i]; // 价值
                q[i] = input.nextInt();        // 主or附件
            }
            System.out.println(getMaxValue(v, p, q, m, n));
        }
    }

    public static int getMaxValue(int[] val, int[] weight, int[] q, int n, int w) {
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (q[i-1] == 0) {
                    // 主件
                    if (weight[i - 1] <= j) {
                        // 用j这么多钱去买 i 件商品 可以获得最大价值
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + val[i - 1]);
                    }
                } else {
                    //附件
                    if (weight[i - 1] + weight[q[i - 1]] <= j) {//附件的话 加上主件一起算
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + val[i - 1]);
                    }
                }
            }
        }
        return dp[n][w];
    }
}
