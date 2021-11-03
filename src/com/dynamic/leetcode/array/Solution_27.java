package com.dynamic.leetcode.array;

public class Solution_27 {

    public static void main(String[] args) {
        int[] numbs = new int[]{2, 3, 2, 2, 3, 2, 4, 3};
        int k = removeElement(numbs, 3);
        for (int i = 0; i < numbs.length; i++) {
            System.out.print(numbs[i] + "  ");
        }
        System.out.println("");
        System.out.println("----------------------------------");
        System.out.println(k);
        System.out.println("----------------------------------");
        numbs = new int[]{2, 3, 2, 2, 3, 2, 4, 3};
        k = removeElement2(numbs, 3);
        System.out.println("");
        System.out.println(k);
        for (int i = 0; i < numbs.length; i++) {
            System.out.print(numbs[i] + "  ");
        }
    }

    /**
     * 替换法
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int cnt = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            // 如果是等于的则计数
            if (nums[i] == val) {
                ++cnt;
            } else {
                // 如果不等于，则将值排最前面去，排到第几个下标去呢，如果把找到的值排前面
                // 比如当前i是1，前面有1个3，则排到a[0]的位置；i=2，前面有一个3，就排到a[i-1]=a[1]的位置，i=2，前面有2个3就排到a[i-2]=a[0]的位置
                nums[i - cnt] = nums[i];
            }
        }
        // 返回不等于，即最后剩下的个数
        return n - cnt;
    }

    /**
     * 双指针法
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement2(int[] nums, int val) {
        // left左边的指针，right和右边的指针
        int left = 0;
        int right = nums.length - 1;
        // 左边的指针小于右边的指针的时候
        while (left < right) {
            // left找到 val停下
            while (left < right && nums[left] != val) {
                left++;
            }
            // right找不到 val停下
            while (left < right && nums[right] == val) {
                right--;
            }
            // left找到第一个为val的值则和right第一个不为val的值进行互换位置
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums[left] == val ? left : left + 1;
    }


}
