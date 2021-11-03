package com.dynamic.leetcode.array;

public class Solution_283 {

    public static void main(String[] args) {
        int[] numbs = new int[]{0, 1, 0, 3, 12};
        moveZeroes(numbs);
        for (int i = 0; i < numbs.length ; i++) {
            System.out.print(numbs[i] + " ");
        }
        numbs = new int[]{0, 1, 0, 3, 12};
        System.out.println();
        System.out.println("---------------------------------");
        moveZeroes2(numbs);
        for (int i = 0; i < numbs.length ; i++) {
            System.out.print(numbs[i] + " ");
        }

    }

    public static void moveZeroes(int[] nums) {
        int n;
        // 边界值校验
        if (nums == null || (n = nums.length) < 1) {
            return;
        }
        // 统计一下有多少个0
        int zeroCount = 0;
        for (int i = 0; i < n; ++i) {
            // 如果是0则计数，不是0则将当前的值赋值到对应的位置
            if (nums[i] == 0) {
                ++zeroCount;
            } else {
                // 当前值到上上一个不为0的值相隔了计数位个0
                nums[i - zeroCount] = nums[i];
            }
        }
        // 将后面多少个值的元素置为0，zeroCount计算后再--
        while (zeroCount > 0) {
            nums[n - zeroCount--] = 0;
        }
    }

    public static void moveZeroes2(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int j = index; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

}
