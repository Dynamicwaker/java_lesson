package com.dynamic.leetcode.array;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_485 {

    public static void main(String[] args) {
        int[] i = new int[]{1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1};
        System.out.println(findMaxConsecutiveOnes(i));

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.offer(2);
        int ine = ((LinkedList<Integer>) queue).pop();
        System.out.println(ine);


        Deque<Integer> q = new LinkedList<>();

    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        // res 最大连续，单次递增值
        int res = 0, t = 0;
        for (int num : nums) {
            // 值为1，t增加
            if (num == 1) {
                ++t;
            } else {
                // 可能是最大值，与之前存的最大值进行比较，并清空t的值再次计数
                res = Math.max(res, t);
                t = 0;
            }
        }
        return Math.max(res, t);
    }

}
