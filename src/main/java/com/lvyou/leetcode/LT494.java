package com.lvyou.leetcode;

/**
 * @Author: VernLv
 * @Data: Create in 15:33 2019/8/12
 */
public class LT494 {
    public static int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWays(nums,0,S);
    }

    private static int findTargetSumWays(int[] nums, int i, int S){
        if (i == nums.length - 1) {
            return Math.abs(S) == nums[i] ? 1: 0;
        }
        return findTargetSumWays(nums,i+1,S - nums[i]) + findTargetSumWays(nums,i+1,S + nums[i]);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        System.out.println(findTargetSumWays(nums,3));
    }
}
